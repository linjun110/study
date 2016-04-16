package com.linjun.language.java;

import com.linjun.language.java.exception.BusinessException;
import com.linjun.language.java.worker.FooWorker;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class App {
    private static Logger logger = LogManager.getLogger(App.class);
    private final static String EXCHANGE_NAME = "helloExchange";

    public static void main( String[] args )
    {
        try{
            init();
            // launch 10 threads to receive a topic of rabbit mq
            for(int i=0; i<5; i++){
                new Thread(new FooWorker("bindKey1")).start();
            }
            for(int i=0; i<5; i++){
                new Thread(new FooWorker("bindKey2")).start();
            }
            while(true){
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            logger.fatal("main thread interrupted");
        }catch(BusinessException e1){
            logger.fatal("Fail to execute.");
        }
    }

    private static void init() throws BusinessException{
        initRabbitMq();
    }

    private static void initRabbitMq() throws BusinessException {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            // declare exchange
            channel.exchangeDeclare(EXCHANGE_NAME, "topic");

            channel.close();
            connection.close();

        }catch(TimeoutException e) {
            logger.error("timeout when connecting to rabbit mq");
            throw new BusinessException(e, null, 0, "init rabbitmq failed");
        }catch(IOException e1) {
            logger.error("io exception when connecting to rabbit mq");
            throw new BusinessException(e1, null, 0, "init rabbitmq failed");
        }
    }
}
