package com.dao;

import com.entity.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.List;
import java.util.Map;

@Mapper
public interface PictureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Picture row);

    Picture selectByPrimaryKey(Integer id);

    List<Picture> selectAll();

    int updateByPrimaryKey(Picture row);

    /**
     * 展示公告图
     * @param limitNum
     * @return
     */
    List<Map<String,Object>> selectNotice(@Param("limitNum") Integer limitNum);

    /**
     * 查询商品全部主展示图
     * @param productId
     * @return
     */
    List<Map<String,Object>> selectAllWithPdt(@Param("productId") Integer productId);

    /**
     * 商品非公告展示图
     * @param productId
     * @return
     */
    List<String> selectNotNotice(@Param("productId") Integer productId);
}
