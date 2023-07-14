package com.controller;

import com.entity.User;
import com.service.UserService;
import com.utils.Email;
import com.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/11
 * @Version 1.0
 * @Since 1.0
 */

@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 登录，如果查询到用户，发送验证码
     * @param email
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public Map<String,Object> login(@RequestParam("email") String email, @RequestParam("password") String password)
                        throws MessagingException{
        HashMap<String, Object> result = new HashMap<>();
        Integer userID = userService.login(email,password);
        //邮箱密码匹配成功
        if (userID != null){
            //生成验证码
            String authCode = Integer.toString((int)Math.floor(Math.random() * 100000));
            //发送邮箱验证码
            Email.sendEmail(email,"本次登录的验证码为：" + authCode);
            result.put("authCode",authCode);
        }
        result.put("userID",userID);
        return result;
    }

    /**
     * 注册
     * @param realname
     * @param password
     * @param username
     * @param phone
     * @param email
     * @param sex
     * @return
     */
    @RequestMapping("/register")
    public boolean register(
            @RequestParam("realname") String realname,@RequestParam("password") String password,
            @RequestParam("username") String username,@RequestParam("phone") String phone,
            @RequestParam("email") String email,@RequestParam(value = "sex",required = false,defaultValue = "2") Byte sex
    ){
        User user = new User();
        user.setRealname(realname);
        user.setPassword(MD5.encode(password));
        user.setUsername(username);
        user.setPhoneNum(phone);
        user.setMailbox(email);
        user.setSex(sex);
        user.setHeadPortrait("a.jpg");
        return userService.register(user);
    }
    /**
     * 接收注册按钮验证码请求，并发送验证码
     * @param email
     * @return
     * @throws MessagingException
     */
    @RequestMapping("/getcode")
    String getCode(@RequestParam("email") String email) throws MessagingException {
        String registerAuthCode = Integer.toString((int)Math.floor(Math.random() * 100000));
        Email.sendEmail(email,"本次注册的验证码为：" + registerAuthCode);
        return registerAuthCode;
    }

    /**
     * 检查手机号 邮箱 用户名是否唯一
     * @param username
     * @param phone
     * @param email
     * @return 信息是否存在
     */
    @RequestMapping("/checkunique")
    boolean checkUnique(@RequestParam(value = "username",required = false) String username,
                        @RequestParam(value = "phone",required = false) String phone,
                        @RequestParam(value = "email",required = false) String email){
        System.out.println("username = " + username);
        System.out.println("phone = " + phone);
        System.out.println("email = " + email);
        return userService.checkUnique(username, phone, email);
    }
}
