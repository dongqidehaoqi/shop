package com.service;

import com.entity.Address;

import java.util.List;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/22
 * @Version 1.0
 * @Since 1.0
 */
public interface AddressService {
    /**
     * 添加地址
     * @param address
     * @return
     */
    Integer addAddress(Address address);
    /**
     * 用户ID查询
     * @param userId
     * @return
     */
    List<Address> queryByUserId(Integer userId);

    /**
     * 更新地址信息
     * @param address
     * @return
     */
    Integer updateById(Address address);

    /**
     * 根据地址ID删除
     * @param id
     * @return
     */
    Integer deleteById(Integer id);
}
