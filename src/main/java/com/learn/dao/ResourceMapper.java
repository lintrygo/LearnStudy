package com.learn.dao;

import com.learn.bean.Resource;
import com.learn.bean.ResourceExample;
import java.util.List;

import com.learn.pojo.ResourceListVO;
import org.apache.ibatis.annotations.Param;

public interface ResourceMapper {
    long countByExample(ResourceExample example);

    int deleteByExample(ResourceExample example);

    int deleteByPrimaryKey(Integer resourceId);

    int insert(Resource record);

    int insertSelective(Resource record);

    List<Resource> selectByExample(ResourceExample example);

    Resource selectByPrimaryKey(Integer resourceId);

    int updateByExampleSelective(@Param("record") Resource record, @Param("example") ResourceExample example);

    int updateByExample(@Param("record") Resource record, @Param("example") ResourceExample example);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
    List<ResourceListVO> resoureList(@Param("courseId") Integer courseId, @Param("stageId") Integer stageId, @Param("moduleId") Integer moduleId, @Param("catalogId") Integer catalogId);
}