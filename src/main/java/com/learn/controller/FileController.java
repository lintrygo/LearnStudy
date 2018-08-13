package com.learn.controller;

import com.learn.service.UploadService;
import com.learn.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
    @Autowired
    private UploadService uploadService;

    @RequestMapping("/back/deletePic")
    @ResponseBody
    public ResponseResult deletePic(){

        return new ResponseResult();

    }

    @RequestMapping("/back/uploadFile")
    @ResponseBody
    public ResponseResult uploadFile(@RequestParam("file") MultipartFile file){
        ResponseResult res=uploadService.uploadImg(file);
        return res;

    }
}
