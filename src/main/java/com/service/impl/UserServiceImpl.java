package com.service.impl;

import com.config.ImageConf;
import com.dao.UserMapper;
import com.entity.User;
import com.service.UserService;
import com.utils.ImgUtil;
import com.utils.MD5;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
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
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ImageConf imageConf;

    /**
     * 查询用户头像和昵称
     * @param userId
     * @return
     */
    @Override
    public List<Map<String, Object>> showSimpleInfo(Integer userId) {
        List<Map<String, Object>> simpleInfo = userMapper.selectSimpleInfo(userId);
        return simpleInfo;
    }

    /**
     * 通过邮箱获取密码
     * @param email
     * @return
     */
    @Override
    public Integer login(String email,String getPwd) {
        List<Map<String,Object>> loginInfo = userMapper.selectByEmail(email);
        System.out.println(loginInfo);
        //如果用户存在，匹配密码,此时list不为空
        if(!CollectionUtils.isEmpty(loginInfo)){
            String encode = MD5.encode(getPwd);
            //密码匹配返回用户ID
            if (encode.equals(loginInfo.get(0).get("password"))){
                return (Integer) loginInfo.get(0).get("id");
            }else {
                return null;
            }
        }else {
            //用户不存在返回null
            return null;
        }
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    public boolean register(User user) {
        int num = userMapper.insertByBatch(user);
        if (num == 1){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 检查是否唯一
     * @param username
     * @param phone
     * @param email
     * @return 信息是否存在
     */
    @Override
    public boolean checkUnique(String username, String phone, String email) {
        return userMapper.selectByBatch(username, phone, email) == 1;
    }

    /**
     * 更新用户信息
     * @param userId
     * @param username
     * @param headPortrait
     * @param sex
     * @return
     */
    @Override
    public boolean updateInfo(Integer userId, String username, MultipartFile headPortrait, Byte sex, HttpServletRequest request) {
        try {
            //上传图片就处理，没有就不处理
            if (headPortrait != null ){
                MultipartFile[] imgs = {headPortrait};
                long time = System.currentTimeMillis();
                //两个文件加同步更新，后期可以修改
                //ImgUtil.upload(imgs,"E:\\VueProject\\shop\\src\\assets\\img" + "\\" + time + ".png",400,400);
                ImgUtil.upload(imgs,imageConf.getLocation() + "\\" + time + ".png",400,400);
                return userMapper.updateInfo(userId, username,time + ".png", sex) == 1;
            }else {
                return userMapper.updateInfo(userId, username,null, sex) == 1;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 查询 头像 昵称 性别
     * @param userId
     * @return
     */
    @Override
    public List<Map<String, Object>> simpleInfo(Integer userId) {
        return userMapper.selectSome(userId);
    }
}
