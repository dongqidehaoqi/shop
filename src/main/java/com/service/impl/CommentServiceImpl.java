package com.service.impl;

import com.dao.CommentMapper;
import com.entity.Comment;
import com.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/16
 * @Version 1.0
 * @Since 1.0
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    /**
     * 查询评论
     * @param productId
     * @return
     */
    @Override
    public List<Map<String, Object>> queryComment(Integer productId) {
        List<Map<String, Object>> maps = commentMapper.selectByProduct(productId);
        return maps;
    }

    /**
     * 添加评论
     * @param comment
     * @return
     */
    @Override
    public List<Map<String, Object>> addComment(Comment comment) {
        if(commentMapper.insert(comment) == 1 ){
            return commentMapper.selectByProduct(comment.getProductId());
        }
        return null;
    }
}
