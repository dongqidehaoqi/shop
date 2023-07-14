package com.service.impl;

import com.dao.CollectionMapper;
import com.entity.Collection;
import com.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/14
 * @Version 1.0
 * @Since 1.0
 */
@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionMapper collectionMapper;

    /**
     * 查看用户收藏夹
     * @param userId
     * @param pdtKeyword
     * @return
     */
    @Override
    public List<Map<String, Object>> collectionOfUser(Integer userId,String pdtKeyword) {
        List<Map<String, Object>> maps = collectionMapper.selectCollection(userId,pdtKeyword);
        return maps;
    }

    /**
     * 添加收藏夹记录
     * @param userId
     * @param productId
     * @return
     */
    @Override
    public boolean addColl(Integer userId, Integer productId) {
        //先删除
        collectionMapper.deleteByUserIdAndProductId(userId,productId);
        //再添加
        Integer succeed = collectionMapper.insertColl(userId,new Date(),productId);
        return succeed == 1;
    }

    /**
     * 根据主键删除收藏夹记录
     * @param id
     * @return
     */
    @Override
    public boolean deleteById(Integer id) {
        return collectionMapper.deleteByPrimaryKey(id) == 1;
    }

    /**
     * 根据用户id和商品id查询
     * @param userId
     * @param productId
     * @return
     */
    @Override
    public Integer selectByUserIdAndProductId(Integer userId, Integer productId) {
        //返回是否能查到记录
        return collectionMapper.selectByUserIdAndProductId(userId, productId);
    }

    /**
     * 根据用户id和商品id删除
     * @param userId
     * @param productId
     * @return
     */
    @Override
    public boolean deleteByUserIdAndProductId(Integer userId, Integer productId) {
        return collectionMapper.deleteByUserIdAndProductId(userId,productId) == 1;
    }


}
