package com.dao;

import com.entity.Product;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ProductMapper {
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("modifyTime") Date modifyTime);

    int insert(Product row);

    Product selectByPrimaryKey(@Param("id") Integer id, @Param("modifyTime") Date modifyTime);

    List<Product> selectAll();

    int updateByPrimaryKey(Product row);

    /**
     * 查询首页
     * @param startLine
     * @param needNum
     * @return
     */
    List<Map<String,Object>> selectHomePage(@Param("startLine") Integer startLine,@Param("needNum") Integer needNum);
    /**
     * 查询个人喜好
     * @param userId
     * @param startLine
     * @param needNum
     * @return
     */
    List<Map<String,Object>> selectByPersonalLove(@Param("userId") Integer userId,@Param("startLine") Integer startLine,@Param("needNum") Integer needNum);

    /**
     * 根据关键字查询
     * @return
     */
    List<Map<String,Object>> selectByKeyword(@Param("keyword") String keyword);

    /**
     * 商品详细信息
     * @param productId
     * @return
     */
    List<Map<String,Object>> selectDetail(@Param("productId") Integer productId);

    /**
     * 商品列表
     * @param fatherIds
     * @return
     */
    List<Map<String,Object>> selectProductList(@Param("fatherIds") Integer[] fatherIds,
                                               @Param("priceFloor") Double priceFloor,
                                               @Param("priceUpper") Double priceUpper,
                                               @Param("merchantId") Integer merchantId);

    /**
     * 所选类型下销量前十的商品
     * @param fatherIds
     * @return
     */
    List<Map<String,Object>> selectHotSale(@Param("fatherIds") Integer[] fatherIds);
}
