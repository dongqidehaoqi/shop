package com.service;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/9
 * @Version 1.0
 * @Since 1.0
 */
public interface ProductService {
    /**
     * 没有历史记录的时候展示这个
     * @param startLine
     * @param needLine
     * @return
     */
    List<Map<String,Object>> showHomePage(Integer startLine,Integer needLine);
    /**
     * 猜你喜欢
     * @param userId
     * @param startLine
     * @param needLine
     * @return
     */
    List<Map<String,Object>> guessYourLove(Integer userId,Integer startLine,Integer needLine);

    /**
     * 关键字查询
     * @param keyword
     * @return
     */
    List<Map<String,Object>> searchByKeyword(String keyword);

    /**
     * 商品信息
     * @param productId
     * @return
     */
    List<Map<String,Object>> queryDetail(Integer productId);

    /**
     * 商品列表
     * @param fatherIds
     * @return
     */
    List<Map<String,Object>> queryProductList(Integer[] fatherIds,Double priceFloor, Double priceUpper, Integer merchantId);

    /**
     * 查询所选类型下销量前十的商品
     * @return
     */
    List<Map<String,Object>> queryHotSale(Integer[] fatherIds);
}
