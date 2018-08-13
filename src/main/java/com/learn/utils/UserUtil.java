package com.learn.utils;

import com.learn.bean.User;

import javax.servlet.http.HttpServletRequest;

public class UserUtil {
    public static User getLoginUser(HttpServletRequest request){
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        return loginUser;
    }

    public static void setLoginUser(HttpServletRequest request,User user){
        request.getSession().setAttribute("loginUser",user);
    }
}
