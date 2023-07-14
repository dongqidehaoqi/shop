package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.MerchantService;
import com.service.ProductService;
import com.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/21
 * @Version 1.0
 * @Since 1.0
 */
@RestController
@RequestMapping("/list")
public class ProductListControl {
    @Autowired
    private ProductTypeService productTypeService;
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private ProductService productService;
    /**
     * 相关类型
     * @param fatherIds
     * @return
     */
    @RequestMapping("/classifications")
    public Object aboutClassifications(@RequestParam("fatherIds") Integer[] fatherIds){
        return productTypeService.queryChildrenType(fatherIds);
    }

    /**
     * 相关商家
     * @param fatherIds
     * @return
     */
    @RequestMapping("/merchants")
    public Object aboutMerchants(@RequestParam("fatherIds") Integer[] fatherIds){
        return merchantService.queryAboutMerchant(fatherIds);
    }

    /**
     * 商品列表
     * @param fatherIds
     * @param pageNum
     * @param orderBy 排序字段
     * @param order 升降序
     * @return
     */
    @RequestMapping("/products")
    public Object productList(@RequestParam("fatherIds") Integer[] fatherIds,
                              @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize",defaultValue = "24") Integer pageSize,
                              @RequestParam(value = "orderBy",required = false) String orderBy,
                              @RequestParam(value = "order",required = false) String order,
                              @RequestParam(value = "priceFloor",required = false) Double priceFloor,
                              @RequestParam(value = "priceUpper",required = false) Double priceUpper,
                              @RequestParam(value = "merchantId",required = false) Integer merchantId){
        //限制排序字段
        Map<String,String> orderBys = new HashMap();
        orderBys.put("saleNum","sale_num");
        orderBys.put("price","preferential_price");
        //限制排序方式
        Set<String> orders = new HashSet<>();
        orders.add("desc");
        orders.add("asc");
        if(orderBy != null && orderBy != "" && order != null && order != ""){
            if(orderBys.get(orderBy) != null && orders.contains(order)){
                PageHelper.startPage(pageNum,pageSize,orderBys.get(orderBy) + " " + order);
                System.out.println("已排序");
            }
        }else {
            PageHelper.startPage(pageNum,pageSize);
            System.out.println("未排序");
        }
        List<Map<String, Object>> maps = productService.queryProductList(fatherIds,priceFloor,priceUpper,merchantId);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(maps, 5);
        return pageInfo;
    }

    /**
     * 热销商品前十
     * @param fatherIds
     * @return
     */
    @RequestMapping("/hotsale")
    public Object hotSale(@RequestParam("fatherIds") Integer[] fatherIds){
        return productService.queryHotSale(fatherIds);
    }
}
