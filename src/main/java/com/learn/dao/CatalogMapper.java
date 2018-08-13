package com.learn.dao;

import com.learn.bean.Catalog;
import com.learn.bean.CatalogExample;
import java.util.List;

import com.learn.pojo.CatalogListVO;
import org.apache.ibatis.annotations.Param;

public interface CatalogMapper {
    long countByExample(CatalogExample example);

    int deleteByExample(CatalogExample example);

    int deleteByPrimaryKey(Integer catalogId);

    int insert(Catalog record);

    int insertSelective(Catalog record);

    List<Catalog> selectByExample(CatalogExample example);

    Catalog selectByPrimaryKey(Integer catalogId);

    int updateByExampleSelective(@Param("record") Catalog record, @Param("example") CatalogExample example);

    int updateByExample(@Param("record") Catalog record, @Param("example") CatalogExample example);

    int updateByPrimaryKeySelective(Catalog record);

    int updateByPrimaryKey(Catalog record);

    List<CatalogListVO> catalogList(@Param("courseId") Integer courseId, @Param("stageId") Integer stageId,@Param("moduleId") Integer moduleId);
}