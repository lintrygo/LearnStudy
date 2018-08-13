package com.learn.controller;

import com.github.pagehelper.PageInfo;
import com.learn.bean.*;
import com.learn.pojo.CatalogListVO;
import com.learn.pojo.VideoListVO;
import com.learn.service.UploadService;
import com.learn.service.VideoClassService;
import com.learn.service.VideoService;
import com.learn.utils.MsgStatus;
import com.learn.utils.PageBean;
import com.learn.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class VideoController {

    @Autowired
    private VideoClassService videoClassService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private UploadService uploadService;


    @RequestMapping("/back/video/list")
    public ModelAndView list(ModelAndView modelAndView){
        List<VideoClass> videoClassList=videoClassService.getAllList();
        modelAndView.setViewName("/cms/video/list");
        modelAndView.addObject("videoClassList",videoClassList);
        return modelAndView;
    }

    @RequestMapping("/back/video/dataList")
    @ResponseBody
    public PageBean<VideoListVO> dataList(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "length", defaultValue = "10") int pageSize,
                                            @RequestParam(value = "videoClassId",required=false) int videoClassId){
        PageInfo pageInfo = videoService.getDataList((start / pageSize) + 1, pageSize,videoClassId);
        return new PageBean<VideoListVO>(pageInfo);
    }

    @RequestMapping("/back/video/addVideoWithFile")
    @ResponseBody
    public ResponseResult addvideoWithFile(@RequestParam("uploadfile") MultipartFile file, Video video){
        String fileName = file.getOriginalFilename().toString();
        ResponseResult res=uploadService.uploadImg(file);
        if(res.getCode()== MsgStatus.FAILED){
            return res;
        }else{
            String url=(String)res.getObj();
            video.setUrl(url);
            video.setCreateTime(new Date());
            res=videoService.save(video);
        }
        return res;
    }

    @RequestMapping("/back/video/addVideo")
    @ResponseBody
    public ResponseResult addVideo(Video video){
        ResponseResult res=new ResponseResult();
        video.setCreateTime(new Date());
        res=videoService.save(video);
        return res;
    }

    @RequestMapping("/back/video/updateVideo")
    @ResponseBody
    public ResponseResult updateVideo(Video video,Integer delete){
        if(delete==0){
            if(video.getUrl() != null && video.getUrl().trim().length() != 0){
                uploadService.deleteFile(video.getUrl());
                video.setUrl("");
            }
        }
        ResponseResult res=new ResponseResult();
        video.setUpdateTime(new Date());
        res=videoService.update(video);
        return res;
    }

    @RequestMapping("/back/video/updateVideoWithFile")
    @ResponseBody
    public ResponseResult updateVideoWithFile(@RequestParam("uploadfile") MultipartFile file,Video video){
        if(video.getUrl() != null && video.getUrl().trim().length() != 0){
            uploadService.deleteFile(video.getUrl());}
        ResponseResult res=uploadService.uploadImg(file);
        if(res.getCode()== MsgStatus.FAILED){
            return res;
        }else{
            String url=(String)res.getObj();
            video.setUrl(url);
            video.setUpdateTime(new Date());
            res=videoService.update(video);
        }
        return res;
    }

    @RequestMapping("/back/video/deleteVideo")
    @ResponseBody
    public ResponseResult deleteVideo(Integer videoId,String url){
        if(url!=null){
            uploadService.deleteFile(url);}
        ResponseResult res=new ResponseResult();
        res=videoService.delete(videoId);
        return res;
    }
}
