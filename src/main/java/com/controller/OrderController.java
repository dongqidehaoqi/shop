package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.entity.Data;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.service.OrderInfoService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/24
 * @Version 1.0
 * @Since 1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderInfoService orderInfoService;

    /**
     * 添加订单
     * @param product
     * @param addressId
     * @param userId
     * @param allPrice
     * @return
     */
    @RequestMapping("/add_order")
    public boolean addOrder(@RequestParam("product") String product,
                            @RequestParam("addressId") Integer addressId,
                            @RequestParam("userId") Integer userId,
                            @RequestParam("allPrice") Double allPrice){
        orderInfoService.addOrder(product,addressId,userId,allPrice);
        return false;
    }
}
