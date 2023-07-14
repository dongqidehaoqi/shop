package com.dao;

import com.entity.ProductModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductModel row);

    ProductModel selectByPrimaryKey(Integer id);

    List<ProductModel> selectAll();

    int updateByPrimaryKey(ProductModel row);

    /**
     * 商品型号
     * @param productId
     * @return
     */
    List<Map<String,Object>> selectModel(@Param("productId")Integer productId);
}
