package com.service;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/9
 * @Version 1.0
 * @Since 1.0
 */
public interface PictureService {
    /**
     * 公告图
     * @param limitNum
     * @return
     */
    List<Map<String,Object>> showNotice(Integer limitNum);

    /**
     * 全部主展示图
     * @param productId
     * @return
     */
    List<Map<String,Object>> showMain(Integer productId);

    /**
     * 所有非公告图
     * @param productId
     * @return
     */
    List<String> showNotNotice(Integer productId);
}
