package com.learn.controller;

import com.github.pagehelper.PageInfo;
import com.learn.bean.Course;
import com.learn.bean.Module;
import com.learn.bean.Stage;
import com.learn.pojo.ModuleListVO;
import com.learn.service.CourseService;
import com.learn.service.ModuleService;
import com.learn.service.StageService;
import com.learn.service.UploadService;
import com.learn.service.impl.MouleServiceImpl;
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
public class ModuleController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private StageService stageService;
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private UploadService uploadService;


    @RequestMapping("/back/module/list")
    public ModelAndView list(ModelAndView modelAndView){
        List<Course> courseList=courseService.getAllList();
        List<Stage> stageList=stageService.getAllList();
        modelAndView.setViewName("/cms/module/list");
        modelAndView.addObject("courseList",courseList);
        modelAndView.addObject("stageList",stageList);
        return modelAndView;
    }

    @RequestMapping("/back/module/dataList")
    @ResponseBody
    public PageBean<ModuleListVO> dataList(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "length", defaultValue = "10") int pageSize,
                                     @RequestParam(value = "courseId",required=false) int courseId,@RequestParam(value = "stageId",required=false) int stageId){
        PageInfo pageInfo = moduleService.getDataList((start / pageSize) + 1, pageSize,courseId,stageId);
        return new PageBean<ModuleListVO>(pageInfo);
    }

    @RequestMapping("/back/module/addModule")
    @ResponseBody
    public ResponseResult addModule(@RequestParam("uploadfile") MultipartFile file, Module module){
        ResponseResult res=uploadService.uploadImg(file);
        if(res.getCode()== MsgStatus.FAILED){
            return res;
        }else{
            String url=(String)res.getObj();
            module.setLogo(url);
            module.setCreateTime(new Date());
            res=moduleService.save(module);
        }
        return res;
    }

    @RequestMapping("/back/module/updateModule")
    @ResponseBody
    public ResponseResult updateModule(Module module){
        ResponseResult res=new ResponseResult();
        module.setUpdateTime(new Date());
        res=moduleService.update(module);
        return res;
    }

    @RequestMapping("/back/module/updateModuleWithFile")
    @ResponseBody
    public ResponseResult updateModuleWithFile(@RequestParam("uploadfile") MultipartFile file,Module module){
        if(module.getLogo()!=null){
            uploadService.deleteFile(module.getLogo());}
        ResponseResult res=uploadService.uploadImg(file);
        if(res.getCode()== MsgStatus.FAILED){
            return res;
        }else{
            String url=(String)res.getObj();
            module.setLogo(url);
            module.setUpdateTime(new Date());
            res=moduleService.update(module);
        }
        return res;
    }

    @RequestMapping("/back/module/deleteModule")
    @ResponseBody
    public ResponseResult deleteModule(Integer moduleId,String url){
        if(url!=null){
            uploadService.deleteFile(url);}
        ResponseResult res=new ResponseResult();
        res=moduleService.delete(moduleId);
        return res;
    }

}
