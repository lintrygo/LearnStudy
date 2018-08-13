package com.learn.dao;

import com.learn.bean.VideoClass;
import com.learn.bean.VideoClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoClassMapper {
    long countByExample(VideoClassExample example);

    int deleteByExample(VideoClassExample example);

    int deleteByPrimaryKey(Integer videoClassId);

    int insert(VideoClass record);

    int insertSelective(VideoClass record);

    List<VideoClass> selectByExample(VideoClassExample example);

    VideoClass selectByPrimaryKey(Integer videoClassId);

    int updateByExampleSelective(@Param("record") VideoClass record, @Param("example") VideoClassExample example);

    int updateByExample(@Param("record") VideoClass record, @Param("example") VideoClassExample example);

    int updateByPrimaryKeySelective(VideoClass record);

    int updateByPrimaryKey(VideoClass record);
}