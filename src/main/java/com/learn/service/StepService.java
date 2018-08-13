package com.learn.service;

import com.github.pagehelper.PageInfo;
import com.learn.bean.Step;
import com.learn.pojo.StepListVO;

public interface StepService extends BaseService<Step> {
    PageInfo<StepListVO> getDataList(Integer pageNum, Integer pageSize, Integer courseId, Integer stageId, Integer moduleId,Integer catalogId);
}
