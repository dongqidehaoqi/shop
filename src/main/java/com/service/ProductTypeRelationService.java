package com.service;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/5
 * @Version 1.0
 * @Since 1.0
 */
public interface ProductTypeRelationService {
    //根据关键字查询
    public List<Map<String,Object>> searchByKeyword(String keyword);
}
