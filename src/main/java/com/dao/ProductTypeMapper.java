package com.dao;

import com.entity.ProductType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductType row);

    ProductType selectByPrimaryKey(Integer id);

    List<ProductType> selectAll();

    int updateByPrimaryKey(ProductType row);

    //查询一级商品类型
    List<Map<String,Object>> selectFirstProductType(@Param("limitNum") Integer limitNum);

    //查询子商品类型
    List<Map<String,Object>> selectChildrenType(@Param("fatherIds") Integer[] fatherIds);
}
