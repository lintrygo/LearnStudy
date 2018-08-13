package com.learn.dao;

import com.learn.bean.PostClass;
import com.learn.bean.PostClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostClassMapper {
    long countByExample(PostClassExample example);

    int deleteByExample(PostClassExample example);

    int deleteByPrimaryKey(Integer postClassId);

    int insert(PostClass record);

    int insertSelective(PostClass record);

    List<PostClass> selectByExample(PostClassExample example);

    PostClass selectByPrimaryKey(Integer postClassId);

    int updateByExampleSelective(@Param("record") PostClass record, @Param("example") PostClassExample example);

    int updateByExample(@Param("record") PostClass record, @Param("example") PostClassExample example);

    int updateByPrimaryKeySelective(PostClass record);

    int updateByPrimaryKey(PostClass record);
}