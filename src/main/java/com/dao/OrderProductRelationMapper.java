package com.dao;

import com.entity.Data;
import com.entity.OrderProductRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface OrderProductRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderProductRelation row);

    OrderProductRelation selectByPrimaryKey(Integer id);

    List<OrderProductRelation> selectAll();

    int updateByPrimaryKey(OrderProductRelation row);

    /**
     * 批量插入数据
     * @param products
     * @param userId
     * @param orderId
     * @return
     */
    int insertOPRs(@Param("products")List<Data> products,@Param("userId") Integer userId,@Param("orderId") Integer orderId);
}
