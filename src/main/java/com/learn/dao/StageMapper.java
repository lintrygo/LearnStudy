package com.learn.dao;

import com.learn.bean.Stage;
import com.learn.bean.StageExample;
import java.util.List;

import com.learn.pojo.StageListVO;
import org.apache.ibatis.annotations.Param;

public interface StageMapper {
    long countByExample(StageExample example);

    int deleteByExample(StageExample example);

    int deleteByPrimaryKey(Integer stageId);

    int insert(Stage record);

    int insertSelective(Stage record);

    List<Stage> selectByExample(StageExample example);

    Stage selectByPrimaryKey(Integer stageId);

    int updateByExampleSelective(@Param("record") Stage record, @Param("example") StageExample example);

    int updateByExample(@Param("record") Stage record, @Param("example") StageExample example);

    int updateByPrimaryKeySelective(Stage record);

    int updateByPrimaryKey(Stage record);

    List<StageListVO> stageList(Integer courseId);
}