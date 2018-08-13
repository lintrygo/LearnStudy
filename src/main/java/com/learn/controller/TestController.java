package com.learn.controller;


import com.learn.config.rabbitmq.RabbitMQUtils;
import com.learn.service.mq.consumer.impl.ConsumerHandlerServiceImpl;
import com.learn.utils.AliYunClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    @Autowired
    private RabbitMQUtils rabbitMQUtils;

    @Autowired
    private ConsumerHandlerServiceImpl consumerHandlerServiceImpl;

    @RequestMapping("/vb")
    public String test(ModelMap model){
        try {
            System.out.println("sdfsdf");
            model.put("time", "dddd");
            SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(dateFormater.parse(dateFormater.format(new Date())));

 //             rabbitMQUtils.sendMsg("kill");
//            rabbitMQUtils.sendMsg("mav","fast1");
//            System.out.println("发送消息");
//            int i = 0;
//            while (i<50) {
//                HashMap<String, Object> hm = new HashMap();
//                hm.fput("tagId", i);
//                rabbitMQUtils.sendMsg("tree",hm);
//                System.out.println("发送第"+i+"消息");
//                i++;
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "cms/login";
    }

    @Resource
    private AliYunClient ossClient;

    private static SecureRandom random=new SecureRandom();
    @RequestMapping( value = "/headImgUpload", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> headImgUpload(HttpServletRequest request, MultipartFile file) {
        Map<String, Object> value = new HashMap<String, Object>();
        value.put("success", true);
        value.put("errorCode", 0);
        value.put("errorMsg", "");
        try {
            // String head = userService.updateHead(file, 4);//此处是调用上传服务接口，4是需要更新的userId 测试数据。
            //value.put("data", head);
            //  ossClient=new OssClient();
            String realPath=request.getSession().getServletContext().getRealPath("img");
            String originalFilename=file.getOriginalFilename();
            String ext=originalFilename.substring(originalFilename.lastIndexOf("."));
            SimpleDateFormat formattter=new SimpleDateFormat("yyyy/MM/dd");
            String filePath=formattter.format(new Date());
            String fileName=getRandomFileName()+ext;
            String tempPathName=realPath+ File.separator+fileName;
            File tempFile=new File(tempPathName);



            String name = ossClient.uploadFile(filePath,fileName,file.getInputStream());
            //String imgUrl = ossClient.getImgUrl(name);
            value.put("errorMsg", name);
        } catch (Exception e) {
            // e.printStackTrace();
            value.put("success", false);
            value.put("errorCode", 200);
            value.put("errorMsg", "图片上传失败");
        }
        return value;
    }

    public String getRandomFileName(){
        long millis=System.currentTimeMillis();
        int end3=random.nextInt(999);
        return  millis+String.format("%03d",end3);
    }
}

