package com.xuanf;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringbootAsyncTestApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        //一个简单的邮件
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setSubject("一封简单的邮件");
        simpleMailMessage.setText("蛋龙珠你好");

        simpleMailMessage.setTo("1037366853@qq.com");
        simpleMailMessage.setFrom("1187922037@qq.com");

        mailSender.send(simpleMailMessage);

    }

    @Test
    void contextLoads2() throws MessagingException {

        //一个复杂的邮件~
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装~
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        //正文
        helper.setSubject("一封复杂的邮件");
        helper.setText("<p style='color:pink'>龙太子你好啊</p>", true);

        //附件
        helper.addAttachment("1.jpg", new File("C:\\Users\\11879\\Pictures\\头像\\橙子.jpg"));
        helper.addAttachment("2.jpg", new File("C:\\Users\\11879\\Pictures\\yys\\千姬021920x1080.jpg"));

        helper.setTo("1037366853@qq.com");
        helper.setFrom("1187922037@qq.com");

        mailSender.send(mimeMessage);
    }

    //封装成方法：
    public void sendMail(Boolean html, String subject, String text) throws MessagingException {

        //一个复杂的邮件~
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装~
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, html);

        //正文
        helper.setSubject(subject);
        helper.setText(text, true);

        //附件
        helper.addAttachment("1.jpg", new File("C:\\Users\\11879\\Pictures\\头像\\橙子.jpg"));
        helper.addAttachment("2.jpg", new File("C:\\Users\\11879\\Pictures\\yys\\千姬021920x1080.jpg"));

        helper.setTo("1037366853@qq.com");
        helper.setFrom("1187922037@qq.com");

        mailSender.send(mimeMessage);
    }
}
