package com.service;

import com.entity.Cart;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/9
 * @Version 1.0
 * @Since 1.0
 */
public interface CartService {

    /**
     * 购物车商品数量
     * @param userId
     * @return
     */
    Integer cartNum(Integer userId);

    /**
     * 查看购物车商品
     * @param userId
     * @return
     */
    Map<String, List<Object>> queryCart(Integer userId);

    /**
     * 更新购物车商品数量
     * @param userId
     * @param productId
     * @param num
     * @return
     */
    boolean updateNum(Integer userId, Integer productId, Integer num);

    /**
     * 插入购物车记录
     * @param cart
     * @return
     */
    boolean addCart(Cart cart);

    /**
     * 删除购物车记录
     * @param userId
     * @param productId
     * @return
     */
    void deleteExist(Integer userId, Integer productId);

    /**
     * 根据主键删除记录
     * @param id
     * @return
     */
    boolean deleteById(Integer id);

    /**
     * 根据ID批量删除记录
     * @param ids
     * @return
     */
    Integer deleteByIds(Integer[] ids);
}
