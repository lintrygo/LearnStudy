package com.learn.config;

import com.learn.service.mq.consumer.impl.ConsumerHandlerServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanInInitialize implements InitializingBean   {

    @Autowired
    private ConsumerHandlerServiceImpl consumerHandlerServiceImpl;

    @Override
    public void afterPropertiesSet() throws Exception {
        //consumerHandlerServiceImpl.consume();
    }
}
