package com.service;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/15
 * @Version 1.0
 * @Since 1.0
 */
public interface BrowsingHistoryService {
    /**
     * 查询历史记录数量
     * @param userId
     * @return
     */
    Integer selectCount(Integer userId);
    /**
     * 查询历史记录
     * @param userId
     * @return
     */
    List<Map<String, Object>> queryHistroy(Integer userId);

    /**
     * 添加历史记录
     * @param userId
     * @param productId
     * @return
     */
    boolean addHistory(Integer userId, Integer productId);

    /**
     * 删除单个历史记录
     * @param userId
     * @param productId
     * @return
     */
    boolean deleteHistory(Integer userId, Integer productId);
}
