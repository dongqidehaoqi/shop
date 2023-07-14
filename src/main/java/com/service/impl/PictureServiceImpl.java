package com.service.impl;

import com.dao.PictureMapper;
import com.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/9
 * @Version 1.0
 * @Since 1.0
 */
@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureMapper pictureMapper;

    /**
     * 公告图
     * @param limitNum
     * @return
     */
    @Override
    public List<Map<String, Object>> showNotice(Integer limitNum) {
        List<Map<String, Object>> notices = pictureMapper.selectNotice(limitNum);
        return notices;
    }

    /**
     * 全部主展示图
     * @param productId
     * @return
     */
    @Override
    public List<Map<String, Object>> showMain(Integer productId) {
        List<Map<String, Object>> maps = pictureMapper.selectAllWithPdt(productId);
        return maps;
    }

    /**
     * 所有非公告图
     * @param productId
     * @return
     */
    @Override
    public List<String> showNotNotice(Integer productId) {
        return pictureMapper.selectNotNotice(productId);
    }


}
