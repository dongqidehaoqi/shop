package com.controller;

import com.entity.PictureType;
import com.service.PictureTypeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/5/5
 * @Version 1.0
 * @Since 1.0
 */
@Controller
@ResponseBody
public class PictureTypeController {
    @Autowired
    private  PictureTypeService pictureTypeService;
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public List<PictureType> show(@RequestParam("id") int id,@RequestParam("name") String name){
        System.out.println("id = " + id + " name = " + name);
        return pictureTypeService.selectAll();
    }

}
