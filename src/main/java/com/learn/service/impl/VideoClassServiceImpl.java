package com.learn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.learn.bean.*;
import com.learn.dao.PostClassMapper;
import com.learn.dao.VideoClassMapper;
import com.learn.service.PostClassService;
import com.learn.service.VideoClassService;
import com.learn.utils.MsgStatus;
import com.learn.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoClassServiceImpl implements VideoClassService {
    @Autowired
    private VideoClassMapper videoClassMapper;

    @Override
    public PageInfo<VideoClass> getDataList(Integer pageNum, Integer pageSize) {
        if (pageNum != null && pageSize != null){
            PageHelper.startPage(pageNum,pageSize);
        }
        VideoClassExample example = new VideoClassExample();
        example.setOrderByClause("weight desc,update_time desc");
        List<VideoClass> videoClassList= videoClassMapper.selectByExample(example);
        return new PageInfo<VideoClass>(videoClassList);
    }

    @Override
    public ResponseResult save(VideoClass entity) {
        ResponseResult res= new ResponseResult();
        try{
            videoClassMapper.insert(entity);
            res.setCode(MsgStatus.SUCCESS);
            res.setMessage("新增视频类别成功！");
        }catch(Exception e){
            res.setMessage("新增视频类别失败！");
        }
        return res;
    }

    @Override
    public ResponseResult delete(Integer id) {
        ResponseResult res= new ResponseResult();
        try{
            videoClassMapper.deleteByPrimaryKey(id);
            res.setCode(MsgStatus.SUCCESS);
            res.setMessage("删除视频类别成功！");
        }catch(Exception e){
            res.setMessage("删除视频类别失败！");
        }
        return res;
    }

    @Override
    public ResponseResult update(VideoClass entity) {
        ResponseResult res= new ResponseResult();
        try{
            videoClassMapper.updateByPrimaryKeySelective(entity);
            res.setCode(MsgStatus.SUCCESS);
            res.setMessage("修改视频类别成功！");
        }catch(Exception e){
            res.setMessage("修改视频类别失败！");
        }
        return res;
    }

    @Override
    public List<VideoClass> getAllList() {
        VideoClassExample example = new VideoClassExample();
        example.setOrderByClause("weight desc,update_time desc");
        List<VideoClass> videoClassList= videoClassMapper.selectByExample(example);
        return  videoClassList;
    }

    @Override
    public List<VideoClass> getList(Integer id) {
        return null;
    }
}
