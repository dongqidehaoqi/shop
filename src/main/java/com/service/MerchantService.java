package com.service;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/16
 * @Version 1.0
 * @Since 1.0
 */
public interface MerchantService {
    /**
     * 查询商品商家信息
     * @param productId
     * @return
     */
    List<Map<String,Object>> queryMerchantByPdt(Integer productId);

    /**
     * 商品列表中的相关商家
     * @param fatherIds
     * @return
     */
    List<Map<String,Object>> queryAboutMerchant(Integer[] fatherIds);
}
