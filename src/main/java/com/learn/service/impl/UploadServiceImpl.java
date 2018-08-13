package com.learn.service.impl;

import com.learn.service.UploadService;
import com.learn.utils.AliYunClient;
import com.learn.utils.MsgStatus;
import com.learn.utils.RandomUtils;
import com.learn.utils.ResponseResult;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UploadServiceImpl implements UploadService {

    @Resource
    private AliYunClient ossClient;

    @Override
    public ResponseResult uploadImg(MultipartFile file) {
        ResponseResult res=new ResponseResult();
        try {
            String originalFilename=file.getOriginalFilename();
            String ext=originalFilename.substring(originalFilename.lastIndexOf("."));
            SimpleDateFormat formattter=new SimpleDateFormat("yyyy/MM/dd");
            String filePath=formattter.format(new Date());
            String fileName= new RandomUtils().getRandomFileName()+ext;
            String url = ossClient.uploadFile(filePath,fileName,file.getInputStream());
            res.setCode(MsgStatus.SUCCESS);
            res.setMessage("图片上传成功！");
            res.setObj(url);

        } catch (Exception e) {
            res.setMessage("图片上传失败！");
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void deleteFile(String fileUrl){
        try {
            ossClient.deleteFile(fileUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void test(){
//        System.out.println("wwww");
//        String testString="http://zwh123.oss-cn-shenzhen.aliyuncs.com/2018/04/02/1522653624477945.jpg?Expires=1838013624&OSSAccessKeyId=LTAIbk1CPyhZPD8k&Signature=lxz7KS9NiOWK3Fs73ijXQf7%2Fvw0%3D";
//        System.out.println(StringUtils.substringBetween(testString,"com/","?" ));
//    }


}
