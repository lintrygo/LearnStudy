package com.learn.controller;

import com.github.pagehelper.PageInfo;
import com.learn.bean.Course;
import com.learn.service.CourseService;
import com.learn.service.UploadService;
import com.learn.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class CourseController {
    @Resource
    private HttpSession httpSession;
    @Autowired
    private CourseService courseService;

    @Autowired
    private UploadService uploadService;

    @RequestMapping("/back/course/list")
    public ModelAndView list(ModelAndView modelAndView){
        modelAndView.setViewName("/cms/course/list");
        return modelAndView;
    }

    @RequestMapping("/back/course/dataList")
    @ResponseBody
    public PageBean<Course> dataList(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "length", defaultValue = "10") int pageSize){
        PageInfo pageInfo = courseService.getDataList((start / pageSize) + 1, pageSize);
        return new PageBean<Course>(pageInfo);
    }

    @RequestMapping("/back/course/addCourse")
    @ResponseBody
    public ResponseResult addCourse(@RequestParam("uploadfile") MultipartFile file, Course course){
        ResponseResult res=uploadService.uploadImg(file);
        if(res.getCode()== MsgStatus.FAILED){
            return res;
        }else{
            String url=(String)res.getObj();
            course.setLogo(url);
            course.setCreateTime(new Date());
            res=courseService.save(course);
        }
        return res;
    }

    @RequestMapping("/back/course/updateCourse")
    @ResponseBody
    public ResponseResult updateCourse(Course course){
        ResponseResult res=new ResponseResult();
        course.setUpdateTime(new Date());
        res=courseService.update(course);
        return res;
    }

    @RequestMapping("/back/course/updateCourseWithFile")
    @ResponseBody
    public ResponseResult updateCourseWithFile(@RequestParam("uploadfile") MultipartFile file,Course course){
        if(course.getLogo()!=null){
            uploadService.deleteFile(course.getLogo());}
        ResponseResult res=uploadService.uploadImg(file);
        if(res.getCode()== MsgStatus.FAILED){
            return res;
        }else{
            String url=(String)res.getObj();
            course.setLogo(url);
            course.setUpdateTime(new Date());
            res=courseService.update(course);
        }
        return res;
    }

    @RequestMapping("/back/course/deleteCourse")
    @ResponseBody
    public ResponseResult deleteCourse(Integer courseId,String url){
        if(url!=null){
            uploadService.deleteFile(url);}
        ResponseResult res=new ResponseResult();
        res=courseService.delete(courseId);
        return res;
    }


}
