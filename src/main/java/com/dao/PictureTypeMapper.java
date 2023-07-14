package com.dao;

import com.entity.PictureType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PictureTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PictureType row);

    PictureType selectByPrimaryKey(Integer id);

    List<PictureType> selectAll();

    int updateByPrimaryKey(PictureType row);
}
