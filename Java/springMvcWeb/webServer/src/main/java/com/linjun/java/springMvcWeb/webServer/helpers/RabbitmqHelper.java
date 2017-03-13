package com.linjun.java.springMvcWeb.webServer.helpers;

import com.rabbitmq.client.*;
import org.apache.log4j.LogManager;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;

/**
 * Created by linjun on 16/4/16.
 */
public class RabbitmqHelper {
    private static Logger logger = LogManager.getLogger(RabbitmqHelper.class);
    private final static String EXCHANGE_NAME = "helloExchange";

    static{
        receive();
    }

    public static void send(String msg) throws IOException {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.basicPublish(EXCHANGE_NAME, "bindKey1", null, msg.getBytes());
            logger.info(" [x] Sent '" + msg + "'");

            channel.close();
            connection.close();

        }catch(TimeoutException e){
            logger.error("connect to rabbit mq time out");
        }
    }

    public static void receive(){
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            String queueName = channel.queueDeclare().getQueue();

            channel.queueBind(queueName, EXCHANGE_NAME, "bindKey2");

            logger.info(" [*] Waiting for messages.");

            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    String message = new String(body, "UTF-8");
                    logger.info(" [x] Received '" + message + "'");
                }
            };
            channel.basicConsume(queueName, true, consumer);
        }catch(TimeoutException e){
            logger.error("connect to rabbit mq time out");
        }catch(IOException e2){
            logger.error("io exception when recieving");
        }
    }
}
