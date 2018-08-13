package com.learn.controller.front;

import com.learn.bean.*;
import com.learn.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.List;


@Controller("frontController")
@RequestMapping("/learn/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private StageService stageService;
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private StepService stepService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("/front/course/index");
        List<Course> courseList= courseService.getAllList();
        modelAndView.addObject("courseList",courseList);
        return modelAndView;
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public ModelAndView stageIndex(@PathVariable(value="id") Integer id, ModelAndView modelAndView) {
        modelAndView.setViewName("/front/course/stage");
        List<Stage> stageList= stageService.getList(id);
        if(stageList!=null && stageList.size()>0){
            List<Module> moduleList = moduleService.getList(stageList.get(0).getStageId());
            modelAndView.addObject("stageName",stageList.get(0).getName());
            modelAndView.addObject("moduleList",moduleList);
        }
        modelAndView.addObject("stageList",stageList);
        return modelAndView;
    }

    @RequestMapping(value = "/stage/{id}",method = RequestMethod.GET)
    public ModelAndView stage(@PathVariable(value="id") Integer id, ModelAndView modelAndView) {
        modelAndView.setViewName("/front/course/stage");
        List<Stage> stageList=null;
        Stage stage= stageService.selectById(id);
        if(stage!=null){
          stageList= stageService.getList(stage.getCourseId());
          modelAndView.addObject("stageName",stage.getName());
        }
        List<Module> moduleList = moduleService.getList(id);
        modelAndView.addObject("moduleList",moduleList);
        modelAndView.addObject("stageList",stageList);
        return modelAndView;
    }

    @RequestMapping(value = "/content/{id}",method = RequestMethod.GET)
    public ModelAndView contentIndex(@PathVariable(value="id") Integer id, ModelAndView modelAndView) {
        modelAndView.setViewName("/front/course/content");
        List<Catalog> catalogList= catalogService.getList(id);
        Module module = moduleService.selectById(id);
        Stage stage = stageService.selectById(module.getStageId());
        modelAndView.addObject("moduleModel",module);
        modelAndView.addObject("stageModel",stage);
        if(catalogList!=null && catalogList.size()>0){
            List<Step> stepList = stepService.getList(catalogList.get(0).getCatalogId());
            modelAndView.addObject("catalog",catalogList.get(0));
            modelAndView.addObject("stepList",stepList);
        }
        modelAndView.addObject("catalogList",catalogList);
        return modelAndView;
    }
}
