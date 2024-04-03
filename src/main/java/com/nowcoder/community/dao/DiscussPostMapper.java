package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    // 根据用户userId、偏移量和显示数量返回帖子
    List<DiscussPost> selectDiscussPosts(@Param("userId") int userId, @Param("offset")int offset, @Param("limit")int limit);

    // 根据用户id获取帖子的数量
    int selectDiscussPostRows(int userId);

    // 插入帖子
    int insertDiscussPost(DiscussPost discussPost);

    // 根据帖子id获取帖子
    DiscussPost selectDiscussPostById(int id);
}
