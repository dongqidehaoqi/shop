package com.dao;

import com.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderInfoMapper {
    Integer deleteByPrimaryKey(Integer id);

    /**
     * 插入订单信息
     * @param row
     * @return
     */
    Integer insert(OrderInfo row);

    OrderInfo selectByPrimaryKey(Integer id);

    List<OrderInfo> selectAll();

    Integer updateByPrimaryKey(OrderInfo row);

    /**
     * 查询待收货商品数量
     * @param userId
     * @return
     */
    Integer selectWaitReceiveNUm(@Param("userId") Integer userId);

    /**
     * 查询待发货商品数量
     * @param userId
     * @return
     */
    Integer selectWaitSendNum(@Param("userId") Integer userId);

    /**
     * 查询待付款商品数量
     * @param userId
     * @return
     */
    Integer selectWaitPayNum(@Param("userId") Integer userId);

    /**
     * 查询待评价商品数量
     * @param userId
     * @return
     */
    Integer selectWaitCommentNum(@Param("userId") Integer userId);

    /**
     * 查询用户的订单
     * @param userId
     * @param orderStatus
     * @param logisticsStatus
     * @param keyword
     * @return
     */
    List<Map<String,Object>> selectOfUser(@Param("userId") Integer userId,@Param("orderStatus") Integer orderStatus,
                                          @Param("logisticsStatus") Integer logisticsStatus,@Param("keyword") String keyword);

    /**
     * 查询购买过的店铺
     * @param userId
     * @return
     */
    List<Map<String,Object>> selectShopByBought(@Param("userId") Integer userId);

    /**
     * 插入订单
     * @param orderInfo
     * @return
     */
    Integer insertOrder( OrderInfo orderInfo);

    /**
     * 查询最大的id
     * @return
     */
    Integer selectMaxId();

}
