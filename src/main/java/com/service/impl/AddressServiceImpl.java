package com.service.impl;

import com.dao.AddressMapper;
import com.entity.Address;
import com.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/22
 * @Version 1.0
 * @Since 1.0
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;

    /**
     * 添加收货地址
     * @param address
     * @return
     */
    @Override
    public Integer addAddress(Address address) {
        return addressMapper.insert(address);
    }

    /**
     * 根据用户ID查询
     * @param userId
     * @return
     */
    @Override
    public List<Address> queryByUserId(Integer userId) {
        return addressMapper.selectByUserId(userId);
    }

    /**
     * 更新地址信息
     * @param address
     * @return
     */
    @Override
    public Integer updateById(Address address) {
        return addressMapper.updateByPrimaryKey(address);
    }

    /**
     * 删除地址
     * @param id 主键
     * @return
     */
    @Override
    public Integer deleteById(Integer id) {
        return addressMapper.deleteByPrimaryKey(id);
    }
}
