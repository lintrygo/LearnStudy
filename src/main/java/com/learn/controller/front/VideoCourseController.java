package com.learn.controller.front;

import com.learn.bean.Course;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/learn/videoCourse")
public class VideoCourseController {

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("/front/videoCourse/index");
        return modelAndView;
    }
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public ModelAndView video(@PathVariable(value="id") Integer id, ModelAndView modelAndView) {
        modelAndView.setViewName("/front/videoCourse/video");
        return modelAndView;
    }
}
