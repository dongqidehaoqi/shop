package com.dao;

import com.entity.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account row);

    Account selectByPrimaryKey(Integer id);

    List<Account> selectAll();

    int updateByPrimaryKey(Account row);
}
