package com.mingdev;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot09AsynTaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("MingDev Hello ~");
        mailMessage.setText("Hello Email");
        mailMessage.setTo("2199812260@qq.com");
        mailMessage.setFrom("2199812260@qq.com");
        mailSender.send(mailMessage);
    }

    @Test
    void test2() throws MessagingException {
        //复杂邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        //主题
        helper.setSubject("MingDev 主题");
        //正文
        helper.setText("<p style='color:red'>hello 王博</p>",true);

        //附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\MingDev\\Desktop\\1.jpg"));
        //收发
        helper.setTo("1764451742@qq.com");
        helper.setFrom("2199812260@qq.com");


        mailSender.send(mimeMessage);
    }

    //方法封装
    /**
     *
     * @param html 是否创建支持替代文本的多部分消息，内联
     * @param subject 主题
     * @param text 文本
     * @param h5 是否开启text的html标签转译
     * @param fileName 附件名  1.jpg
     * @param filePath 附件路径 C:\Users\MingDev\Desktop\1.jpg
     * @param toEmail 目标邮箱
     * @param fromEmail 发送邮箱
     * @throws MessagingException 异常
     * @author mingdev 作者
     */
    public void sendMail(Boolean html, String subject,String text,Boolean h5,String fileName,String filePath ,String toEmail,String fromEmail) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,html);
        helper.setSubject(subject);
        helper.setText(text,h5);
        //附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\MingDev\\Desktop\\1.jpg"));
        helper.setTo(toEmail);
        helper.setFrom(fromEmail);
        mailSender.send(mimeMessage);
    }

}
