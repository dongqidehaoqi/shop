package com.service.impl;

import com.dao.ProductTypeRelationMapper;
import com.service.ProductTypeRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/5
 * @Version 1.0
 * @Since 1.0
 */
@Service
public class ProductTypeRelationServiceImpl implements ProductTypeRelationService {
    @Autowired
    private ProductTypeRelationMapper productTypeRelationMapper;

    /**
     * 关键字查询
     * @param keyword
     * @return
     */
    @Override
    public List<Map<String, Object>> searchByKeyword(String keyword) {
        List<Map<String, Object>> selectByKeyword = productTypeRelationMapper.selectByKeyword(keyword);
        return selectByKeyword;
    }
}
