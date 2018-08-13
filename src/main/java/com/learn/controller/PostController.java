package com.learn.controller;

import com.github.pagehelper.PageInfo;
import com.learn.bean.Course;
import com.learn.bean.PostClass;
import com.learn.bean.VideoClass;
import com.learn.service.PostClassService;
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
public class PostController {

    @Autowired
    private PostClassService postClassService;

    @RequestMapping("/back/post/list")
    public ModelAndView list(ModelAndView modelAndView){
        modelAndView.setViewName("/cms/post/list");
        return modelAndView;
    }

    @RequestMapping("/back/post/dataList")
    @ResponseBody
    public PageBean<PostClass> dataList(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "length", defaultValue = "10") int pageSize){
        PageInfo pageInfo = postClassService.getDataList((start / pageSize) + 1, pageSize);
        return new PageBean<PostClass>(pageInfo);
    }

    @RequestMapping("/back/post/addClass")
    @ResponseBody
    public ResponseResult addClass(PostClass postClass){
        ResponseResult res=new ResponseResult();
        postClass.setCreateTime(new Date());
        res=postClassService.save(postClass);
        return res;
    }

    @RequestMapping("/back/post/updateClass")
    @ResponseBody
    public ResponseResult updateClass(PostClass postClass){
        ResponseResult res=new ResponseResult();
        postClass.setUpdateTime(new Date());
        res=postClassService.update(postClass);
        return res;
    }

    @RequestMapping("/back/post/deleteClass")
    @ResponseBody
    public ResponseResult deleteClass(Integer id){
        ResponseResult res=new ResponseResult();
        res=postClassService.delete(id);
        return res;
    }

}
