package com.utils;

import org.springframework.util.DigestUtils;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/5/6
 * @Version 1.0
 * @Since 1.0
 */
public class MD5 {
    private static String salt1 = "!zhang_san/1";
    private static String salt2 = "%758*/1sjk";
    public static String encode(String pwd){
        return DigestUtils.md5DigestAsHex((salt1 + pwd + salt2).getBytes());
    }
}
