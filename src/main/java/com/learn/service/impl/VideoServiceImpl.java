package com.learn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.learn.bean.Video;
import com.learn.dao.VideoMapper;
import com.learn.pojo.VideoListVO;
import com.learn.service.VideoService;
import com.learn.utils.MsgStatus;
import com.learn.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;
    @Override
    public PageInfo<VideoListVO> getDataList(Integer pageNum, Integer pageSize, Integer videoClassId) {
        if (pageNum != null && pageSize != null){
            PageHelper.startPage(pageNum,pageSize);
        }
        List<VideoListVO> videoList= videoMapper.videoList(videoClassId);
        return new PageInfo<VideoListVO>(videoList);
    }

    @Override
    public ResponseResult save(Video entity) {
        ResponseResult res= new ResponseResult();
        try{
            videoMapper.insert(entity);
            res.setCode(MsgStatus.SUCCESS);
            res.setMessage("新增视频成功！");
        }catch(Exception e){
            res.setMessage("新增视频失败！");
        }
        return res;
    }

    @Override
    public ResponseResult delete(Integer id) {
        ResponseResult res= new ResponseResult();
        try{
            videoMapper.deleteByPrimaryKey(id);
            res.setCode(MsgStatus.SUCCESS);
            res.setMessage("删除视频成功！");
        }catch(Exception e){
            res.setMessage("删除视频失败！");
        }
        return res;
    }

    @Override
    public ResponseResult update(Video entity) {
        ResponseResult res= new ResponseResult();
        try{
            videoMapper.updateByPrimaryKeySelective(entity);
            res.setCode(MsgStatus.SUCCESS);
            res.setMessage("修改视频成功！");
        }catch(Exception e){
            res.setMessage("修改视频失败！");
        }
        return res;
    }

    @Override
    public List<Video> getAllList() {
        return null;
    }

    @Override
    public List<Video> getList(Integer id) {
        return null;
    }
}
