package com.utils;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date:2023-02-02
 * Time:18:06
 */
public class Email {
    /**
     * 发送邮箱验证码
     * @param email
     * @param authCode 验证码
     * @throws MessagingException
     */
    public static void sendEmail(String email,String authCode) throws MessagingException {
        // 创建Properties 类用于记录邮箱的一些属性
        Properties props = new Properties();
        // 表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth", "true");
        //此处填写SMTP服务器
        props.put("mail.smtp.host", "smtp.qq.com");
        //端口号，QQ邮箱端口587
        props.put("mail.smtp.port", 587);
        // 此处填写，写信人的账号
        props.put("mail.user", "374761060@qq.com");
        // 此处填写16位STMP口令
        props.put("mail.password", "npsifmkxcywrbjgg");

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码，都不用改直接copy
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人，
        InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
        message.setFrom(form);
        // 设置收件人的邮箱
        InternetAddress to = new InternetAddress(email);
        message.setRecipient(Message.RecipientType.TO, to);
        // 设置邮件标题
        message.setSubject("验证码信息");
        // 设置邮件的内容体
        message.setContent(authCode, "text/html;charset=UTF-8");
        // 最后当然就是发送邮件啦
        Transport.send(message);
    }
}
