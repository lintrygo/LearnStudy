package com.learn.dao;

import com.learn.bean.Step;
import com.learn.bean.StepExample;
import java.util.List;

import com.learn.pojo.StepListVO;
import org.apache.ibatis.annotations.Param;

public interface StepMapper {
    long countByExample(StepExample example);

    int deleteByExample(StepExample example);

    int deleteByPrimaryKey(Integer stepId);

    int insert(Step record);

    int insertSelective(Step record);

    List<Step> selectByExampleWithBLOBs(StepExample example);

    List<Step> selectByExample(StepExample example);

    Step selectByPrimaryKey(Integer stepId);

    int updateByExampleSelective(@Param("record") Step record, @Param("example") StepExample example);

    int updateByExampleWithBLOBs(@Param("record") Step record, @Param("example") StepExample example);

    int updateByExample(@Param("record") Step record, @Param("example") StepExample example);

    int updateByPrimaryKeySelective(Step record);

    int updateByPrimaryKeyWithBLOBs(Step record);

    int updateByPrimaryKey(Step record);

    List<StepListVO> stepList(@Param("courseId") Integer courseId, @Param("stageId") Integer stageId,@Param("moduleId") Integer moduleId,@Param("catalogId") Integer catalogId);
}