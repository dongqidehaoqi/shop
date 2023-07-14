package com.service.impl;

import com.dao.PictureTypeMapper;
import com.entity.PictureType;
import com.service.PictureTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/5/5
 * @Version 1.0
 * @Since 1.0
 */
@Service
public class PictureTypeServiceImpl implements PictureTypeService {
    @Autowired
    private PictureTypeMapper pictureTypeMapper;
    @Override
    public List<PictureType> selectAll() {
        return pictureTypeMapper.selectAll();
    }
}
