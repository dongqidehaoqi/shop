package com.service;

import com.entity.OrderInfo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/9
 * @Version 1.0
 * @Since 1.0
 */
public interface OrderInfoService {
    /**
     * 代收货数量
     * @param userId
     * @return
     */
    Integer waitReceiveNum(Integer userId);

    /**
     * 待发货数量
     * @param userId
     * @return
     */
    Integer waitSendNum(Integer userId);

    /**
     * 待付款数量
     * @param userId
     * @return
     */
    Integer waitPayNum(Integer userId);

    /**
     * 待评论数量
     * @param userId
     * @return
     */
    Integer waitCommentNum(Integer userId);

    /**
     * 条件查询
     * @param userId
     * @param orderStatus
     * @param logisticsStatus
     * @param keyword
     * @return
     */
    List<Map<String,Object>> queryOrderByBatch(Integer userId, Integer orderStatus, Integer logisticsStatus,String keyword);

    /**
     * 购买过的店铺
     * @param userId
     * @return
     */
    Map queryBoughtShop(Integer userId);

    /**
     * 插入订单
     * @param product
     * @param addressId
     * @param userId
     * @param allPrice
     * @return
     */
    boolean addOrder(String product,Integer addressId,Integer userId,Double allPrice);



}
