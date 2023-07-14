package com.dao;

import com.entity.BrowsingHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface BrowsingHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BrowsingHistory row);

    BrowsingHistory selectByPrimaryKey(Integer id);

    List<BrowsingHistory> selectAll();

    int updateByPrimaryKey(BrowsingHistory row);

    /**
     * 查询历史记录的数量
     * @param userId
     * @return
     */
    Integer selectCount(@Param("userId")Integer userId);
    /**
     * 浏览记录
     * @param userId
     * @return
     */
    List<Map<String,Object>> selectHistory(@Param("userId") Integer userId);

    /**
     * 添加浏览记录
     * @param userId
     * @param productId
     * @return
     */
    Integer insertHistory(@Param("userId") Integer userId, @Param("productId") Integer productId, @Param("time")Date time);
    /**
     * 修改历史记录状态达到删除
     * @param userId
     * @param productId
     * @return
     */
    Integer updateHistoryStatus(@Param("userId") Integer userId, @Param("productId") Integer productId);

    /**
     * 彻底删除
     * @param userId
     * @param productId
     * @return
     */
    Integer deleteHistory(@Param("userId") Integer userId, @Param("productId") Integer productId);
}
