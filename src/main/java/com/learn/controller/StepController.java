package com.learn.controller;

import com.github.pagehelper.PageInfo;
import com.learn.bean.*;
import com.learn.pojo.CatalogListVO;
import com.learn.pojo.StepListVO;
import com.learn.service.*;
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
public class StepController {
    @Autowired
    private StepService stepService;
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private StageService stageService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private UploadService uploadService;

    @RequestMapping("/back/step/list")
    public ModelAndView list(ModelAndView modelAndView){
        List<Course> courseList=courseService.getAllList();
        List<Stage> stageList=stageService.getAllList();
        List<Module> moduleList=moduleService.getAllList();
        List<Catalog> catalogList=catalogService.getAllList();
        modelAndView.setViewName("/cms/step/list");
        modelAndView.addObject("courseList",courseList);
        modelAndView.addObject("stageList",stageList);
        modelAndView.addObject("moduleList",moduleList);
        modelAndView.addObject("catalogList",catalogList);
        return modelAndView;
    }

    @RequestMapping("/back/step/dataList")
    @ResponseBody
    public PageBean<StepListVO> dataList(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "length", defaultValue = "10") int pageSize,
                                            @RequestParam(value = "courseId",required=false) int courseId, @RequestParam(value = "stageId",required=false) int stageId, @RequestParam(value = "moduleId",required=false) int moduleId,@RequestParam(value = "catalogId",required=false) int catalogId){
        PageInfo pageInfo = stepService.getDataList((start / pageSize) + 1, pageSize,courseId,stageId,moduleId,catalogId);
        return new PageBean<StepListVO>(pageInfo);
    }

    @RequestMapping("/back/step/addStep")
    @ResponseBody
    public ResponseResult addStep(Step step){
        ResponseResult res=new ResponseResult();
        step.setCreateTime(new Date());
        res=stepService.save(step);
        return res;
    }

    @RequestMapping("/back/step/updateStep")
    @ResponseBody
    public ResponseResult updateCourse(Step step){
        ResponseResult res=new ResponseResult();
        step.setUpdateTime(new Date());
        res=stepService.update(step);
        return res;
    }
    @RequestMapping("/back/step/deleteStep")
    @ResponseBody
    public ResponseResult deleteCourse(Integer stepId){
        ResponseResult res=new ResponseResult();
        res=stepService.delete(stepId);
        return res;
    }
}
