package com.dao;

import com.entity.AdminProductRelation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AdminProductRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminProductRelation row);

    AdminProductRelation selectByPrimaryKey(Integer id);

    List<AdminProductRelation> selectAll();

    int updateByPrimaryKey(AdminProductRelation row);
}
