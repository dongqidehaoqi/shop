package com.dao;

import com.entity.Collection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface CollectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collection row);

    Collection selectByPrimaryKey(Integer id);

    List<Collection> selectAll();

    int updateByPrimaryKey(Collection row);

    /**
     * 查询收藏夹商品
     * @param userId
     * @return
     */
    List<Map<String,Object>> selectCollection(@Param("userId") Integer userId ,@Param("pdtKeyword") String pdtKeyword);

    /**
     * 添加收藏夹记录
     * @param userId
     * @param time
     * @param productId
     * @return
     */
    Integer insertColl(@Param("userId") Integer userId, @Param("time")Date time, @Param("productId") Integer productId);

    /**
     * 根据用户ID和商品ID删除记录
     * @param userId
     * @param productId
     * @return
     */
    Integer deleteByUserIdAndProductId(@Param("userId") Integer userId,@Param("productId") Integer productId);

    /**
     * 根据用户id和商品id查询
     * @param userId
     * @param productId
     * @return
     */
    Integer selectByUserIdAndProductId(@Param("userId") Integer userId, @Param("productId") Integer productId);

}
