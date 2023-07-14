package com.service;

import com.entity.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/9
 * @Version 1.0
 * @Since 1.0
 */
public interface UserService {

    List<Map<String,Object>> showSimpleInfo(Integer userId);

    Integer login(String email,String password);

    boolean register(User user);

    /**
     * 检查用户名、手机号、邮箱是否唯一
     * @return
     */
    boolean checkUnique(String username,String phone, String email);

    /**
     * 更新用户信息
     * @param userId
     * @param username
     * @param headPortrait
     * @param sex
     * @return
     */
    boolean updateInfo(Integer userId, String username, MultipartFile headPortrait, Byte sex, HttpServletRequest request);

    /**
     * 查询头像昵称性别
     * @param userId
     * @return
     */
    List<Map<String,Object>> simpleInfo(Integer userId);
}
