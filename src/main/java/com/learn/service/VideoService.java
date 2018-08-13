package com.learn.service;

import com.github.pagehelper.PageInfo;
import com.learn.bean.Video;
import com.learn.pojo.StageListVO;
import com.learn.pojo.VideoListVO;

public interface VideoService extends BaseService<Video> {
    PageInfo<VideoListVO> getDataList(Integer pageNum, Integer pageSize, Integer videoClassId);
}
