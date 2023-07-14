package com.service;

import com.entity.Collection;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/14
 * @Version 1.0
 * @Since 1.0
 */
public interface CollectionService {

    /**
     * 用户收藏夹
     * @param userId
     * @param pdtKeyword
     * @return
     */
    List<Map<String,Object>> collectionOfUser(Integer userId, String pdtKeyword);

    /**
     * 添加收藏夹记录
     * @param userId
     * @param productId
     * @return
     */
    boolean addColl(Integer userId, Integer productId);

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    boolean deleteById(Integer id);

    /**
     * 根据用户Id和商品id查询
     * @param userId
     * @param productId
     * @return
     */
    Integer selectByUserIdAndProductId(Integer userId,Integer productId);

    /**
     * 根据用户Id和商品id删除
     * @param userId
     * @param productId
     * @return
     */
    boolean deleteByUserIdAndProductId(Integer userId,Integer productId);
}
