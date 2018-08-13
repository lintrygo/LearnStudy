package com.learn.service;

import com.github.pagehelper.PageInfo;
import com.learn.bean.Resource;
import com.learn.pojo.ResourceListVO;
import com.learn.pojo.StepListVO;

public interface ResourceService extends BaseService<Resource> {
    PageInfo<ResourceListVO> getDataList(Integer pageNum, Integer pageSize, Integer courseId, Integer stageId, Integer moduleId, Integer catalogId);
}
