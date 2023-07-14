package com.dao;

import com.entity.Merchant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MerchantMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Merchant row);

    Merchant selectByPrimaryKey(Integer id);

    List<Merchant> selectAll();

    int updateByPrimaryKey(Merchant row);

    /**
     * 商品详情中的商家信息
     *
     * @param productId
     * @return
     */
    List<Map<String, Object>> selectMerWithPdtDetail(@Param("productId") Integer productId);

    /**
     * 商品列表中的相关商家
     * @param fatherIds
     * @return
     */
    List<Map<String,Object>> selectAboutMerchant(@Param("fatherIds") Integer[] fatherIds);

}
