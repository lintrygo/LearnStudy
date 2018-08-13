package com.learn.controller;

import com.learn.bean.Course;
import com.learn.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private CourseService courseService;
    @RequestMapping("/back/index")
    public ModelAndView backIndex(ModelAndView modelAndView){
        modelAndView.setViewName("/cms/index");
        return  modelAndView;
    }

    @RequestMapping(value={"/learn"},method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("/front/index");
        List<Course> courseList=courseService.getRecommedList();
        modelAndView.addObject("courseList",courseList);
        return modelAndView;
    }
}
