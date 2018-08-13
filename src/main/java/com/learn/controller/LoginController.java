package com.learn.controller;


import com.learn.bean.User;
import com.learn.service.UserService;
import com.learn.utils.MsgStatus;
import com.learn.utils.ResponseResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

    private static final Logger logger = LoggerFactory
            .getLogger(LoginController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("/cms/login");
        return mav;
    }

    @RequestMapping("/toLogin")
    @ResponseBody
    public ResponseResult toLogin(User user, HttpSession session){
        logger.debug("用户登录，请求参数=user:"+user);
        ResponseResult responseResult=new ResponseResult();
        if(user==null){
            responseResult.setMessage("请求参数有误，请您稍后再试");
            logger.debug("用户登录，结果=responseResult:"+responseResult);
            return responseResult;
        }
        User searchUser=userService.getAdminByName(user.getName());
        if(searchUser==null){
            responseResult.setMessage("用户名不存在！");
        }else{
            try {
                AuthenticationToken token =new UsernamePasswordToken(user.getName(),user.getPassword().toCharArray());
                Subject subject = SecurityUtils.getSubject();
                subject.login(token);
                session.setAttribute("user",searchUser);
                responseResult.setCode(MsgStatus.SUCCESS);
                responseResult.setMessage("登录成功！");
            } catch (UnknownAccountException e) {
                responseResult.setCode(MsgStatus.SUCCESS);
                responseResult.setMessage("用户名不存在！");
            } catch(AuthenticationException e){
                logger.error("用户登录，用户验证未通过：认证异常，异常信息如下！user=" + user.getName(),e);
                responseResult.setMessage("用户名或密码不正确");
            } catch (Exception e) {
                logger.error("用户登录，用户验证未通过：操作异常，异常信息如下！user=" + user.getName(),e);
                responseResult.setMessage("用户登录失败，请您稍后再试");
            }
        }
        return responseResult;
    }

    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "redirect:"+"/admin/login";
    }

//    @Test
//    public void test(){
//        System.out.println(DigestUtils.md5Hex("123456"));
//    }
}
