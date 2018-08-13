package com.learn.dao;

import com.learn.bean.PostReply;
import com.learn.bean.PostReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostReplyMapper {
    long countByExample(PostReplyExample example);

    int deleteByExample(PostReplyExample example);

    int deleteByPrimaryKey(Integer postReplyId);

    int insert(PostReply record);

    int insertSelective(PostReply record);

    List<PostReply> selectByExample(PostReplyExample example);

    PostReply selectByPrimaryKey(Integer postReplyId);

    int updateByExampleSelective(@Param("record") PostReply record, @Param("example") PostReplyExample example);

    int updateByExample(@Param("record") PostReply record, @Param("example") PostReplyExample example);

    int updateByPrimaryKeySelective(PostReply record);

    int updateByPrimaryKey(PostReply record);
}