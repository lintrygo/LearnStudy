package com.learn.service;

import com.learn.utils.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

     ResponseResult uploadImg(MultipartFile file);
    void deleteFile(String url);
}
