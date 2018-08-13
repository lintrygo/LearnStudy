package com.learn.service;

import com.github.pagehelper.PageInfo;
import com.learn.bean.Catalog;
import com.learn.pojo.CatalogListVO;

public interface CatalogService extends BaseService<Catalog> {
    PageInfo<CatalogListVO> getDataList(Integer pageNum, Integer pageSize, Integer courseId, Integer stageId,Integer moduleId);
}
