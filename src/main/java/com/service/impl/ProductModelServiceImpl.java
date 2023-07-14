package com.service.impl;

import com.dao.ProductModelMapper;
import com.service.ProductModelService;
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
public class ProductModelServiceImpl implements ProductModelService {
    @Autowired
    private ProductModelMapper productModelMapper;
    /**
     * 商品型号信息
     * @param productId
     * @return
     */
    @Override
    public List<Map<String, Object>> queryModel(Integer productId) {
       return productModelMapper.selectModel(productId);
    }
}
