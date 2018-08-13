package com.learn.controller;

import com.github.pagehelper.PageInfo;
import com.learn.bean.Course;
import com.learn.bean.PostClass;
import com.learn.bean.VideoClass;
import com.learn.service.PostClassService;
import com.learn.service.VideoClassService;
import com.learn.utils.PageBean;
import com.learn.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class VideoClassController {

    @Autowired
    private VideoClassService videoClassService;

    @RequestMapping("/back/videoClass/list")
    public ModelAndView list(ModelAndView modelAndView){
        modelAndView.setViewName("/cms/videoClass/list");
        return modelAndView;
    }

    @RequestMapping("/back/videoClass/dataList")
    @ResponseBody
    public PageBean<VideoClass> dataList(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "length", defaultValue = "10") int pageSize){
        PageInfo pageInfo = videoClassService.getDataList((start / pageSize) + 1, pageSize);
        return new PageBean<VideoClass>(pageInfo);
    }

    @RequestMapping("/back/videoClass/addClass")
    @ResponseBody
    public ResponseResult addClass(VideoClass videoClass){
        ResponseResult res=new ResponseResult();
        videoClass.setCreateTime(new Date());
        res=videoClassService.save(videoClass);
        return res;
    }

    @RequestMapping("/back/videoClass/updateClass")
    @ResponseBody
    public ResponseResult updateClass(VideoClass videoClass){
        ResponseResult res=new ResponseResult();
        videoClass.setUpdateTime(new Date());
        res=videoClassService.update(videoClass);
        return res;
    }

    @RequestMapping("/back/videoClass/deleteClass")
    @ResponseBody
    public ResponseResult deleteClass(Integer id){
        ResponseResult res=new ResponseResult();
        res=videoClassService.delete(id);
        return res;
    }

}
