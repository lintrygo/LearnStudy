package com.learn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.learn.bean.Post;
import com.learn.bean.PostClass;
import com.learn.bean.PostClassExample;
import com.learn.dao.CourseMapper;
import com.learn.dao.PostClassMapper;
import com.learn.dao.PostMapper;
import com.learn.service.PostClassService;
import com.learn.service.PostService;
import com.learn.utils.MsgStatus;
import com.learn.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostClassServiceImpl implements PostClassService {
    @Autowired
    private PostClassMapper postClassMapper;
    @Override
    public PageInfo<PostClass> getDataList(Integer pageNum, Integer pageSize) {
        if (pageNum != null && pageSize != null){
            PageHelper.startPage(pageNum,pageSize);
        }
        PostClassExample example = new PostClassExample();
        example.setOrderByClause("weight desc,update_time desc");
        List<PostClass> postClassList= postClassMapper.selectByExample(example);
        return new PageInfo<PostClass>(postClassList);
    }

    @Override
    public ResponseResult save(PostClass entity) {
        ResponseResult res= new ResponseResult();
        try{
            postClassMapper.insert(entity);
            res.setCode(MsgStatus.SUCCESS);
            res.setMessage("新增讨论区版块成功！");
        }catch(Exception e){
            res.setMessage("新增讨论区版块失败！");
        }
        return res;
    }

    @Override
    public ResponseResult delete(Integer id) {
        ResponseResult res= new ResponseResult();
        try{
            postClassMapper.deleteByPrimaryKey(id);
            res.setCode(MsgStatus.SUCCESS);
            res.setMessage("删除讨论区版块成功！");
        }catch(Exception e){
            res.setMessage("删除讨论区版块失败！");
        }
        return res;
    }

    @Override
    public ResponseResult update(PostClass entity) {
        ResponseResult res= new ResponseResult();
        try{
            postClassMapper.updateByPrimaryKeySelective(entity);
            res.setCode(MsgStatus.SUCCESS);
            res.setMessage("修改讨论区版块成功！");
        }catch(Exception e){
            res.setMessage("修改讨论区版块失败！");
        }
        return res;
    }

    @Override
    public List<PostClass> getAllList() {
        return null;
    }

    @Override
    public List<PostClass> getList(Integer id) {
        return null;
    }
}
