package com.service;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/4
 * @Version 1.0
 * @Since 1.0
 */

public interface ProductTypeService {
    /**
     * 查询一级商品类型
     * @param limitNum
     * @return
     */
    List<Map<String,Object>> queryFirstProductType(Integer limitNum);

    /**
     * 查询子商品类型
     * @param fatherIds
     * @return
     */
    List<Map<String,Object>> queryChildrenType(Integer[] fatherIds);

}
