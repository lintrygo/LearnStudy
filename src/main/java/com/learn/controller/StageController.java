package com.learn.controller;

import com.github.pagehelper.PageInfo;
import com.learn.bean.Course;
import com.learn.bean.Stage;
import com.learn.pojo.StageListVO;
import com.learn.service.CourseService;
import com.learn.service.StageService;
import com.learn.utils.PageBean;
import com.learn.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class StageController {
    @Autowired
    private StageService stageService;
    @Autowired
    private CourseService courseService;

    @RequestMapping("/back/stage/list")
    public ModelAndView list(ModelAndView modelAndView){
       List<Course> list=courseService.getAllList();
        modelAndView.setViewName("/cms/stage/list");
        modelAndView.addObject("courseList",list);
        return modelAndView;
    }

    @RequestMapping("/back/stage/dataList")
    @ResponseBody
    public PageBean<StageListVO> dataList(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "length", defaultValue = "10") int pageSize,@RequestParam(value = "courseId",required=false) int courseId){
        PageInfo pageInfo = stageService.getDataList((start / pageSize) + 1, pageSize,courseId);
        return new PageBean<StageListVO>(pageInfo);
    }

    @RequestMapping("/back/stage/addStage")
    @ResponseBody
    public ResponseResult addStage(Stage stage){
        ResponseResult res=new ResponseResult();
        stage.setCreateTime(new Date());
        res=stageService.save(stage);
        return res;
    }

    @RequestMapping("/back/stage/updateStage")
    @ResponseBody
    public ResponseResult updateStage(Stage stage){
        ResponseResult res=new ResponseResult();
        stage.setUpdateTime(new Date());
        res=stageService.update(stage);
        return res;
    }
    @RequestMapping("/back/stage/deleteStage")
    @ResponseBody
    public ResponseResult deleteStage(Integer stageId){
        ResponseResult res=new ResponseResult();
        res=stageService.delete(stageId);
        return res;
    }
}
