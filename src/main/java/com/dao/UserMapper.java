package com.dao;

import com.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User row);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User row);

    /**
     * 展示首页用户头像昵称
     * @param userId
     * @return
     */
    List<Map<String,Object>> selectSimpleInfo(@Param("userId") Integer userId);


    List<Map<String,Object>> selectByEmail(@Param("mailbox") String mailbox);

    int insertByBatch(@Param("user") User user);

    /**
     * 检查 用户名 手机号 邮箱 是否重复
     * @param username
     * @param phone
     * @param email
     * @return
     */
    int selectByBatch(@Param("username") String username,
                      @Param("phone") String phone,
                      @Param("email") String email);

    /**
     * 更新用户头像 昵称 性别
     * @param userId
     * @param username
     * @param headPortrait
     * @return
     */
    Integer updateInfo(@Param("userId") Integer userId,
                       @Param("username") String username,
                       @Param("headPortrait") String headPortrait,
                       @Param("sex") Byte sex);

    /**
     * 查询头像 昵称 性别
     * @param userId
     * @return
     */
    List<Map<String,Object>> selectSome(@Param("userId") Integer userId);
}
