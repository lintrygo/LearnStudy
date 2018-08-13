package com.learn.service;

import com.github.pagehelper.PageInfo;
import com.learn.bean.Module;
import com.learn.pojo.ModuleListVO;
import com.learn.pojo.StageListVO;
import com.learn.utils.ResponseResult;

public interface ModuleService extends BaseService<Module> {

    PageInfo<ModuleListVO> getDataList(Integer pageNum, Integer pageSize,Integer courseId,Integer stageId);

    Module selectById(Integer id);
}
