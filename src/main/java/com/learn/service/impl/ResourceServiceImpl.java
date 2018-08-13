package com.learn.service.impl;

import com.github.pagehelper.PageInfo;
import com.learn.bean.Resource;
import com.learn.pojo.ResourceListVO;
import com.learn.service.ResourceService;
import com.learn.utils.ResponseResult;

import java.util.List;

public class ResourceServiceImpl implements ResourceService {
    @Override
    public PageInfo<ResourceListVO> getDataList(Integer pageNum, Integer pageSize, Integer courseId, Integer stageId, Integer moduleId, Integer catalogId) {
        return null;
    }

    @Override
    public ResponseResult save(Resource entity) {
        return null;
    }

    @Override
    public ResponseResult delete(Integer id) {
        return null;
    }

    @Override
    public ResponseResult update(Resource entity) {
        return null;
    }

    @Override
    public List<Resource> getAllList() {
        return null;
    }

    @Override
    public List<Resource> getList(Integer id) {
        return null;
    }
}
