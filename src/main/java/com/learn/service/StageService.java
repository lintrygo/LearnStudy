package com.learn.service;

import com.github.pagehelper.PageInfo;
import com.learn.bean.Stage;
import com.learn.pojo.StageListVO;
import com.learn.utils.ResponseResult;

import java.util.List;

public interface StageService extends BaseService<Stage> {
    PageInfo<StageListVO> getDataList(Integer pageNum, Integer pageSize,Integer courseId);
    Stage selectById(Integer id);
}
