package com.service.impl;

import com.dao.MerchantMapper;
import com.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/16
 * @Version 1.0
 * @Since 1.0
 */
@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    private MerchantMapper merchantMapper;

    /**
     * 查询商品所在商家信息
     * @param productId
     * @return
     */
    @Override
    public List<Map<String, Object>> queryMerchantByPdt(Integer productId) {
        List<Map<String, Object>> maps = merchantMapper.selectMerWithPdtDetail(productId);
        return maps;
    }

    /**
     * 商品列表中的相关商家
     * @param fatherIds
     * @return
     */
    @Override
    public List<Map<String, Object>> queryAboutMerchant(Integer[] fatherIds) {
        return merchantMapper.selectAboutMerchant(fatherIds);
    }
}
