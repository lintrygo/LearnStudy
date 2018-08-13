package com.learn.service.impl;

import com.learn.bean.User;
import com.learn.dao.UserMapper;
import com.learn.service.UserService;
import com.learn.utils.Md5Util;
import com.learn.utils.MsgStatus;
import com.learn.utils.ResponseResult;
import com.learn.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getAdminByName(String name) {
        return userMapper.getAdminByName(name);
    }

    @Override
    public ResponseResult userLogin(User user, HttpServletRequest request) {
        String password = user.getPassword();
        user.setPassword(Md5Util.getMD5Code(user.getPassword()));
        User findUser = userMapper.userLogin(user);
        if(findUser!=null){
            UserUtil.setLoginUser(request,findUser);
            return new ResponseResult(MsgStatus.SUCCESS,"登陆成功!");
        }else{
            return new ResponseResult(MsgStatus.FAILED,"用户名或密码错误!");
        }
    }

    @Override
    public ResponseResult register(User user, HttpServletRequest request) {
        if(userMapper.getUserByName(user.getName())!=null){
            return new ResponseResult(MsgStatus.FAILED,"该用户名已被注册!");
        }
        user.setPassword(Md5Util.getMD5Code(user.getPassword()));
        if(userMapper.register(user)==1){
            return new ResponseResult(MsgStatus.SUCCESS,"注册成功!");
        }else{
            return new ResponseResult(MsgStatus.FAILED,"该用户名已被注册!");
        }
    }
}
