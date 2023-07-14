package com.service;

import com.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/16
 * @Version 1.0
 * @Since 1.0
 */
public interface CommentService {
    /**
     * 查询商品评论
     * @param productId
     * @return
     */
    List<Map<String,Object>> queryComment(Integer productId);

    /**
     * 添加评论
     * @param comment
     * @return
     */
    List<Map<String, Object>> addComment(Comment comment);

}
