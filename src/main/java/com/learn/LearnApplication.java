package com.learn;

import com.learn.config.rabbitmq.RabbitMQUtils;
import com.learn.service.mq.consumer.impl.ConsumerHandlerServiceImpl;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

import javax.servlet.MultipartConfigElement;


@SpringBootApplication
@MapperScan("com.learn.dao")
@Configuration
public class LearnApplication {




    public static void main(String[] args){
        SpringApplication.run(LearnApplication.class,args);
//        Jedis jedis =new Jedis("localhost");
//        System.out.println(jedis.ping());
//        jedis.append("sss","ssss");


    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大
        factory.setMaxFileSize("10MB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("10MB");
        return factory.createMultipartConfig();
    }

    @Test
    public void testRabbitmq(){

    }


}
