package com.spring.community2.dao;

import com.spring.community2.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    // userId 为 0 时不需要把 userId 拼到 sql 里面，此为一个动态的 sql,offset 是每一页起始的行号，limit 是每页显示多少的数据
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    // @Param 参数是用来给参数取别名；如果是一个动态的 sql，并且这个传入进来有且仅有一个参数，这个参数就必须取别名，
    int selectDiscussPostRows(@Param("userId") int userId);

    int insertDiscussPost(DiscussPost discussPost);

    DiscussPost selectDiscussPostById(int id);

    int updateCommentCount(int id, int commentCount);
}
