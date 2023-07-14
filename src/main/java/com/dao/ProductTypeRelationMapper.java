package com.dao;

import com.entity.ProductTypeRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductTypeRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductTypeRelation row);

    ProductTypeRelation selectByPrimaryKey(Integer id);

    List<ProductTypeRelation> selectAll();

    int updateByPrimaryKey(ProductTypeRelation row);

    //根据搜索框关键字查询
    List<Map<String,Object>> selectByKeyword(@Param("keyword") String keyword);
}
