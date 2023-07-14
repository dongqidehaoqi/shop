package com;

import com.dao.PictureTypeMapper;
import com.entity.PictureType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
class ShopApplicationTests {
    @Autowired
    public PictureTypeMapper pictureTypeMapper;
    @Test
    void contextLoads() {

    }
    @Test
    void  dosome(){
        List<PictureType> pictureTypes = pictureTypeMapper.selectAll();
        System.out.println(pictureTypes);
    }

}
