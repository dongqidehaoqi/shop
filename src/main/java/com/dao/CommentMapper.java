package com.dao;

import com.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment row);

    Comment selectByPrimaryKey(Integer id);

    List<Comment> selectAll();

    int updateByPrimaryKey(Comment row);

    /**
     * 查询评论信息
     * @param productId
     * @return
     */
    List<Map<String,Object>> selectByProduct(@Param("productId") Integer productId);

}
