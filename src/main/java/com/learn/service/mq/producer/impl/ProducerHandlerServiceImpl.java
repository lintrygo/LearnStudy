package com.learn.service.mq.producer.impl;

import com.alibaba.fastjson.JSONObject;
import com.learn.config.rabbitmq.RabbitMQUtils;
import com.learn.service.mq.producer.IProducerHandlerService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProducerHandlerServiceImpl implements IProducerHandlerService {

    private static  final org.slf4j.Logger log = LoggerFactory.getLogger(ProducerHandlerServiceImpl.class);

    @Autowired
    private RabbitMQUtils rabbitMQUtils;

    @Override
    public void sentDataToQueue(String queueKey, Object object) {
        try {
            //rabbitMQUtils.sendMsg(queueKey, JSONObject.toJSON(object).toString());
        } catch (Exception e) {
            log.error(e.toString());
        }
    }
}
