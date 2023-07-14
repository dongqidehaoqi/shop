package com.dao;

import com.entity.FocusStore;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface FocusStoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FocusStore row);

    FocusStore selectByPrimaryKey(Integer id);

    List<FocusStore> selectAll();

    int updateByPrimaryKey(FocusStore row);
}
