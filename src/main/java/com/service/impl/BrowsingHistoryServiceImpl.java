package com.service.impl;

import com.dao.BrowsingHistoryMapper;
import com.service.BrowsingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/15
 * @Version 1.0
 * @Since 1.0
 */
@Service
public class BrowsingHistoryServiceImpl implements BrowsingHistoryService {
    @Autowired
    private BrowsingHistoryMapper browsingHistoryMapper;

    /**
     * 查询历史记录数量
     * @param userId
     * @return
     */
    @Override
    public Integer selectCount(Integer userId) {
        return browsingHistoryMapper.selectCount(userId);
    }

    /**
     * 浏览历史记录
     * @param userId
     * @return
     */
    @Override
    public List<Map<String, Object>> queryHistroy(Integer userId) {
        List<Map<String, Object>> histroy = browsingHistoryMapper.selectHistory(userId);
        if(!ObjectUtils.isEmpty(histroy)){
            System.out.println("history" +  histroy);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
            histroy.forEach((item)->{
                item.replace("time",simpleDateFormat.format(item.get("time")));
            });
        }
        return histroy;
    }

    /**
     * 添加历史记录，先删除，再添加
     * @param userId
     * @param productId
     * @return
     */
    @Override
    public boolean addHistory(Integer userId, Integer productId) {
        System.out.println("开始添加记录");
        browsingHistoryMapper.deleteHistory(userId,productId);
        return browsingHistoryMapper.insertHistory(userId,productId,new Date()) == 1;
    }

    /**
     * 删除单个历史记录
     * @param userId
     * @param productId
     * @return
     */
    @Override
    public boolean deleteHistory(Integer userId, Integer productId) {
        return browsingHistoryMapper.updateHistoryStatus(userId, productId) == 1 ;
    }
}
