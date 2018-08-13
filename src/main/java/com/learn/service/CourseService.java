package com.learn.service;

import com.github.pagehelper.PageInfo;
import com.learn.bean.Course;
import com.learn.utils.ResponseResult;

import java.util.List;


public interface CourseService extends BaseService<Course> {

     PageInfo<Course> getDataList(Integer pageNum, Integer pageSize);

     List<Course> getRecommedList();


}
