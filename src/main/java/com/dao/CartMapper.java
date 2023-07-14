package com.dao;

import com.entity.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CartMapper {
    /**
     * 根据主键删除购物车记录
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    int insert(Cart row);

    Cart selectByPrimaryKey(Integer id);

    List<Cart> selectAll();

    int updateByPrimaryKey(Cart row);

    /**
     * 购车商品数量
     * @param userId
     * @return
     */
    int selectCartNum(@Param("userId") Integer userId);

    /**
     * 查看购物车
     * @param userId
     * @return
     */
    List<Map<String,Object>> selectCart(@Param("userId") Integer userId);

    /**
     * 修改商品数量
     * @param userId
     * @param num
     * @return
     */
    Integer updateNum(@Param("userId") Integer userId,@Param("productId") Integer productId, @Param("num") Integer num);

    /**
     * 插入购物车记录
     * @param cart
     * @return
     */
    Integer insertCart(Cart cart);

    /**
     * 删除购物车记录
     * @return
     */
    Integer deleteExist(@Param("userId") Integer userId, @Param("productId") Integer productId);

    /**
     * 根据id批量删除记录
     * @param ids
     * @return
     */
    Integer deleteByIds(@Param("ids") Integer[] ids);

}
