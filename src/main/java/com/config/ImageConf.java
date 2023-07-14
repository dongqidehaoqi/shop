package com.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/25
 * @Version 1.0
 * @Since 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "image")
public class ImageConf {

    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ImageConf() {
    }

}
