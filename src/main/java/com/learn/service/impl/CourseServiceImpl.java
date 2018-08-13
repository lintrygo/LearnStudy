package com.learn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.learn.bean.Course;
import com.learn.bean.CourseExample;
import com.learn.dao.CourseMapper;
import com.learn.service.CourseService;
import com.learn.utils.MsgStatus;
import com.learn.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public PageInfo<Course> getDataList(Integer pageNum, Integer pageSize) {
        if (pageNum != null && pageSize != null){
            PageHelper.startPage(pageNum,pageSize);
        }
        CourseExample example = new CourseExample();
       example.setOrderByClause("weight desc,update_time desc");
        List<Course> courseList= courseMapper.selectByExample(example);
        return new PageInfo<Course>(courseList);
    }

    @Override
    public List<Course> getRecommedList() {
        return courseMapper.getRecommendList();
    }

    @Override
    public ResponseResult save(Course course){
       ResponseResult res= new ResponseResult();
       try{
           courseMapper.insert(course);
           res.setCode(MsgStatus.SUCCESS);
           res.setMessage("新增课程成功！");
       }catch(Exception e){
           res.setMessage("新增课程失败！");
        }
        return res;
    }

    @Override
    public ResponseResult delete(Integer courseId) {
        ResponseResult res= new ResponseResult();
        try{
            courseMapper.deleteByPrimaryKey(courseId);
            res.setCode(MsgStatus.SUCCESS);
            res.setMessage("删除课程成功！");
        }catch(Exception e){
            res.setMessage("删除课程失败！");
        }
        return res;
    }

    @Override
    public ResponseResult update(Course course) {
        ResponseResult res= new ResponseResult();
        try{
            courseMapper.updateByPrimaryKeySelective(course);
            res.setCode(MsgStatus.SUCCESS);
            res.setMessage("修改课程成功！");
        }catch(Exception e){
            res.setMessage("修改课程失败！");
        }
        return res;
    }

    @Override
    public List<Course> getAllList() {
        CourseExample example = new CourseExample();
        example.setOrderByClause("weight desc,update_time desc");
        List<Course> courseList= courseMapper.selectByExample(example);
        return  courseList;
    }

    @Override
    public List<Course> getList(Integer id) {
        return null;
    }

}
