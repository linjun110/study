package com.linjun.language.java.worker;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by linjun on 16/4/16.
 */
public class FooWorker implements Runnable {
    private final static String EXCHANGE_NAME = "helloExchange";
    private final String bindKey;

    public FooWorker(String bindKey){
        this.bindKey = bindKey;
    }

    public void run() {
        // listen to rabbitmq and print message
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.exchangeDeclare(EXCHANGE_NAME, "topic");
            String queueName = channel.queueDeclare().getQueue();

            channel.queueBind(queueName, EXCHANGE_NAME, this.bindKey);

            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(" [x] " + Thread.currentThread().getName() + " Received '" + envelope.getRoutingKey() + "':'" + message + "'");
                }
            };
            channel.basicConsume(queueName, true, consumer);
        }catch(TimeoutException e){
        }catch(IOException e1){
        }
    }
}
