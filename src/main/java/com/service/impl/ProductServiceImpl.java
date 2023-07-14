package com.service.impl;

import com.dao.ProductMapper;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/9
 * @Version 1.0
 * @Since 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    /**
     * 首页展示商品,没有历史记录的时候就展示这个
     * @param startLine
     * @param needLine
     * @return
     */
    @Override
    public List<Map<String, Object>> showHomePage(Integer startLine, Integer needLine) {
        return productMapper.selectHomePage(startLine,needLine);
    }

    /**
     * 查询用户可能喜欢的商品
     * @param userId
     * @param startLine
     * @param needNum
     * @return
     */
    @Override
    public List<Map<String, Object>> guessYourLove(Integer userId,Integer startLine,Integer needNum) {
        List<Map<String, Object>> personalLove = productMapper.selectByPersonalLove(userId,startLine,needNum);
        return personalLove;
    }

    /**
     * 根据关键词查询
     * @param keyword
     * @return
     */
    @Override
    public List<Map<String, Object>> searchByKeyword(String keyword) {
        List<Map<String, Object>> maps = productMapper.selectByKeyword(keyword);
        return maps;
    }

    /**
     * 商品信息
     * @param productId
     * @return
     */
    @Override
    public List<Map<String, Object>> queryDetail(Integer productId) {
        return productMapper.selectDetail(productId);
    }

    /**
     * 商品列表
     * @param fatherIds
     * @return
     */
    @Override
    public List<Map<String, Object>> queryProductList(Integer[] fatherIds, Double priceFloor, Double priceUpper, Integer merchantId) {
        return productMapper.selectProductList(fatherIds,priceFloor,priceUpper,merchantId);
    }

    /**
     * 查询所选类型下销量前十的商品
     * @param fatherIds
     * @return
     */
    @Override
    public List<Map<String, Object>> queryHotSale(Integer[] fatherIds) {
        return productMapper.selectHotSale(fatherIds);
    }


}
