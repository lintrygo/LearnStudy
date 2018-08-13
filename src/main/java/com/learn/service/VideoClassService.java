package com.learn.service;

import com.github.pagehelper.PageInfo;
import com.learn.bean.PostClass;
import com.learn.bean.VideoClass;

public interface VideoClassService extends BaseService<VideoClass> {
    PageInfo<VideoClass> getDataList(Integer pageNum, Integer pageSize);
}
