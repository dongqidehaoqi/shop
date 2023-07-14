package com.service.impl;

import com.dao.ProductTypeMapper;
import com.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/4
 * @Version 1.0
 * @Since 1.0
 */
@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    private ProductTypeMapper productTypeMapper;

    /**
     * 一级商品类型
     * @param limitNum
     * @return
     */
    @Override
    public List<Map<String,Object>> queryFirstProductType(Integer limitNum) {
        List<Map<String,Object>> firstProductTypes = productTypeMapper.selectFirstProductType(limitNum);
        return firstProductTypes;
    }

    /**
     * 子商品类型
     * @param fatherIds
     * @return
     */
    @Override
    public List<Map<String, Object>> queryChildrenType(Integer[] fatherIds) {
        return productTypeMapper.selectChildrenType(fatherIds);
    }
}
