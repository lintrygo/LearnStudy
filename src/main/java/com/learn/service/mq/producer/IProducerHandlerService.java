package com.learn.service.mq.producer;

public interface IProducerHandlerService {

    /**
     * 生产者发送消息到指定队列
     * @param queueKey
     * @param object
     */
    void sentDataToQueue(String queueKey,Object object);
}
