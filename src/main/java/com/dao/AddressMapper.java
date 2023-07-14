package com.dao;

import com.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface AddressMapper {
    /**
     * 删除地址信息
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加地址
     * @param row
     * @return
     */
    int insert(Address row);

    Address selectByPrimaryKey(Integer id);

    List<Address> selectAll();

    /**
     * 修改地址信息
     * @param row
     * @return
     */
    int updateByPrimaryKey(Address row);

    /**
     * 根据用户ID查询
     * @param userId
     * @return
     */
    List<Address> selectByUserId(@Param("userId") Integer userId);
}
