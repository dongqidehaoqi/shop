package com.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.dao.OrderInfoMapper;
import com.dao.OrderProductRelationMapper;
import com.dao.UserMapper;
import com.entity.Data;
import com.entity.OrderInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private OrderProductRelationMapper orderProductRelationMapper;


    /**
     * 代收款商品数量
     * @param userId
     * @return
     */
    @Override
    public Integer waitReceiveNum(Integer userId) {
        Integer waitReceiveNUm = orderInfoMapper.selectWaitReceiveNUm(userId);
        return waitReceiveNUm;
    }

    /**
     * 代发货商品数量
     * @param userId
     * @return
     */
    @Override
    public Integer waitSendNum(Integer userId) {
        Integer waitSendNum = orderInfoMapper.selectWaitSendNum(userId);
        return waitSendNum;
    }

    /**
     * 待付款商品数量
     * @param userId
     * @return
     */
    @Override
    public Integer waitPayNum(Integer userId) {
        Integer waitPayNum = orderInfoMapper.selectWaitPayNum(userId);
        return waitPayNum;
    }

    /**
     * 待评论商品数量
     * @param userId
     * @return
     */
    @Override
    public Integer waitCommentNum(Integer userId) {
        Integer waitCommentNum = orderInfoMapper.selectWaitCommentNum(userId);
        if (waitCommentNum == null ){
            return 0;
        }
        return waitCommentNum;
    }

    /**
     * 根据订单状态查询订单
     * @param userId
     * @param orderStatus
     * @param logisticsStatus
     * @return
     */
    @Override
    public List<Map<String, Object>> queryOrderByBatch(Integer userId, Integer orderStatus, Integer logisticsStatus, String keyword) {
        List<Map<String, Object>> maps = orderInfoMapper.selectOfUser(userId, orderStatus, logisticsStatus,keyword);
        return maps;
    }

    /**
     * 查询购买过的店铺
     * @param userId
     * @return
     */
    @Override
    public Map<String, List<Object>> queryBoughtShop(Integer userId) {
        List<Map<String, Object>> maps = orderInfoMapper.selectShopByBought(userId);
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
     * 插入订单
     * @param product
     * @param addressId
     * @param userId
     * @param allPrice
     * @return
     */
    @Override
    public boolean addOrder(String product,Integer addressId,Integer userId,Double allPrice) {
        //最大id
        Integer maxId = orderInfoMapper.selectMaxId();
        long timeMillis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(timeMillis);
        //创建订单对象
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(maxId + 1);
        orderInfo.setOrderNum(timeMillis+"");
        orderInfo.setOrderTime(timestamp);
        orderInfo.setPayMethod(2);
        orderInfo.setPayMoney(allPrice);
        orderInfo.setPayTime(timestamp);
        orderInfo.setOrderStatus(0);
        orderInfo.setShippingMethod(0);
        orderInfo.setLogisticsStatus(0);
        orderInfo.setWaybillNum(timeMillis+"");
        orderInfo.setStatus(1);
        orderInfo.setAddressId(addressId);
        orderInfo.setUserId(userId);
        orderInfoMapper.insertOrder(orderInfo);
        //创建JSON映射对象
        ObjectMapper objectMapper = new ObjectMapper();
        List<Data> datas = new ArrayList<>();
        try {
            //把JSON转换为JSONArray
            JSONArray objects = JSON.parseArray(product);
            //遍历
            for (int i = 0; i < objects.size(); i++) {
                //把项转为data实体in
                Data data = objectMapper.readValue(objects.getString(i), Data.class);
                //添加到list里面
                datas.add(data);
            }
            int i = orderProductRelationMapper.insertOPRs(datas, userId, maxId + 1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return false;
    }

}
