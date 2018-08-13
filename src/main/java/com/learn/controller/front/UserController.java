package com.learn.controller.front;

import com.learn.bean.User;
import com.learn.service.UserService;
import com.learn.utils.ResponseResult;
import com.learn.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/learn")
public class UserController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public ResponseResult login(User user){
       ResponseResult responseResult=userService.userLogin(user,request);
       return  responseResult;
    }

    @RequestMapping("/register")
    @ResponseBody
    public ResponseResult register(User user){
        ResponseResult responseResult=userService.register(user,request);
        return  responseResult;
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){
        UserUtil.setLoginUser(request,null);
        return "redirect:/learn";
    }

    @RequestMapping(value = "/user/index",method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView){
       modelAndView.setViewName("/front/user/index");
        return modelAndView;
    }


}
