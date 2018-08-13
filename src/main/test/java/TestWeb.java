import com.learn.config.rabbitmq.RabbitMQUtils;
import com.learn.service.mq.consumer.impl.ConsumerHandlerServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class TestWeb {

    @Autowired
    private RabbitMQUtils rabbitMQUtils;

    @Autowired
    private ConsumerHandlerServiceImpl consumerHandlerService;

    @Test
    public void testRabbitMq(){
        System.out.println("发送第"+i+"消息");
        //DigestUtils.md5Hex(user.getPassword())
//        try {
//            consumerHandlerService.consume();
//            int i = 0;
//            while (i<10000) {
//                HashMap<String, Object> hm = new HashMap();
//                hm.put("tagId", i);
//                rabbitMQUtils.sendMsg("publish",hm);
//                System.out.println("发送第"+i+"消息");
//                i++;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
