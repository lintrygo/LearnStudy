package com.learn.service;

import com.learn.bean.User;
import com.learn.utils.ResponseResult;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    User getAdminByName(String name);

    ResponseResult userLogin(User user,HttpServletRequest request);

    ResponseResult register(User user,HttpServletRequest request);

}
