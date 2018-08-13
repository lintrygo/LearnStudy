package com.learn.service;

import com.github.pagehelper.PageInfo;
import com.learn.bean.Stage;
import com.learn.pojo.StageListVO;
import com.learn.utils.ResponseResult;

import java.util.List;

public interface BaseService<T> {

    ResponseResult save(T entity);

    ResponseResult delete(Integer id);

    ResponseResult update(T entity);

    List<T> getAllList();

    List<T> getList(Integer id);
}
