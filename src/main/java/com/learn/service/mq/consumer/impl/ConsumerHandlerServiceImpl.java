package com.learn.service.mq.consumer.impl;

import com.learn.config.rabbitmq.RabbitMQConfiguration;
import com.learn.service.mq.consumer.IConsumerHandlerService;
import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Component
public class ConsumerHandlerServiceImpl implements IConsumerHandlerService {

    private static  final Logger log = LoggerFactory.getLogger(ConsumerHandlerServiceImpl.class);

    @Autowired
    private RabbitMQConfiguration rabbitMQConfiguration;

    private String queueName = "kill";
    @Override
    public void consume() throws Exception {
        Connection connection = rabbitMQConfiguration.getConnection();
         Channel channel = connection.createChannel();
        channel.queueDeclare(queueName,true,false,false,null);
        log.info("Waiting for messages");
        channel.basicQos(1);

        channel.basicConsume(queueName, false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                Map map = (HashMap) SerializationUtils.deserialize(body);
//                System.out.println("Message Number "+ map.get("tagId") + " received.");
                System.out.println(new String(body, "UTF-8"));
                try {
                    //  Thread.sleep(1000);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });



//        final Consumer consumer = new DefaultConsumer(channel){
//
//            public void handleDelivery(String consumerTag, Envelope env, BasicProperties props, byte[] body) throws IOException {
//                // TODO Auto-generated method stub
//                try {
//                    Map map = (HashMap) SerializationUtils.deserialize(body);
//                    System.out.println("Message Number "+ map.get("tagId") + " received.");
//                } catch (Exception e) {
//                    log.info("消息处理失败！");
//                } finally {
//                    //channel.basicAck(env.getDeliveryTag(), false);
//                }
//                //channel.basicAck(env.getDeliveryTag(), false);
//            }
//        };
//        channel.basicConsume(queueName,true,consumer);
    }
}
