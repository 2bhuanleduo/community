package com.nowcoder.community.dao;

import com.nowcoder.community.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

    // 根据评论类型和评论对象查询所有评论
    List<Comment> selectCommentsByEntity(@Param("entityType") int entityType, @Param("entityId") int entityId,
                                         @Param("offset") int offset, @Param("limit") int limit);

    // 根据评论类型和对象查询 评论总数
    int selectCountByEntity(@Param("entityType") int entityType, @Param("entityId") int entityId);

}
