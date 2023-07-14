package com.service.impl;

import com.dao.CartMapper;
import com.entity.Cart;
import com.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;

    /**
     * 购物车商品数量
     * @param userId
     * @return
     */
    @Override
    public Integer cartNum(Integer userId) {
        return cartMapper.selectCartNum(userId);
    }

    /**
     * 查看购物车
     * @param userId
     * @return
     */
    @Override
    public Map<String, List<Object>> queryCart(Integer userId) {
        List<Map<String, Object>> maps = cartMapper.selectCart(userId);
        HashMap<String, List<Object>> result = new HashMap<>();
        maps.forEach((item)->{
            //如果Map里没有数据
            if (result.get(item.get("merchantId").toString()) == null){
                result.put(item.get("merchantId").toString(),new ArrayList<>());
            }
            result.get(item.get("merchantId").toString()).add(item);
        });
        return result;
    }

    /**
     * 更新购物车商品数量
     * @param userId
     * @param productId
     * @param num
     * @return
     */
    @Override
    public boolean updateNum(Integer userId, Integer productId, Integer num) {
        Integer succeed = cartMapper.updateNum(userId, productId, num);
        if (succeed == 1){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 添加购车记录
     * @param cart
     * @return
     */
    @Override
    public boolean addCart(Cart cart) {
        Integer succeed = cartMapper.insertCart(cart);
        return succeed == 1 ;
    }

    /**
     * 删除购物车记录
     * @param userId
     * @param productId
     * @return
     */
    @Override
    public void deleteExist(Integer userId, Integer productId) {
        cartMapper.deleteExist(userId,productId);
    }

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    @Override
    public boolean deleteById(Integer id) {
        return cartMapper.deleteByPrimaryKey(id) == 1;
    }

    /**
     * 根据id批量删除记录
     * @param ids
     * @return
     */
    @Override
    public Integer deleteByIds(Integer[] ids) {
        return cartMapper.deleteByIds(ids);
    }

}
