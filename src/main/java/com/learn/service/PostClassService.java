package com.learn.service;

import com.github.pagehelper.PageInfo;
import com.learn.bean.PostClass;

public interface PostClassService extends BaseService<PostClass> {
    PageInfo<PostClass> getDataList(Integer pageNum, Integer pageSize);
}
