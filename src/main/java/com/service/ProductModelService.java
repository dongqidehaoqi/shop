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
public interface ProductModelService {
    /**
     * 型号信息
     * @param productId
     * @return
     */
    List<Map<String,Object>> queryModel(Integer productId);
}
