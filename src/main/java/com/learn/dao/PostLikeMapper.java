package com.learn.dao;

import com.learn.bean.PostLike;
import com.learn.bean.PostLikeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostLikeMapper {
    long countByExample(PostLikeExample example);

    int deleteByExample(PostLikeExample example);

    int deleteByPrimaryKey(Integer postLikeId);

    int insert(PostLike record);

    int insertSelective(PostLike record);

    List<PostLike> selectByExample(PostLikeExample example);

    PostLike selectByPrimaryKey(Integer postLikeId);

    int updateByExampleSelective(@Param("record") PostLike record, @Param("example") PostLikeExample example);

    int updateByExample(@Param("record") PostLike record, @Param("example") PostLikeExample example);

    int updateByPrimaryKeySelective(PostLike record);

    int updateByPrimaryKey(PostLike record);
}