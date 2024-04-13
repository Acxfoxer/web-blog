package com.lee.onstage.service.impl;

import cn.hutool.extra.mail.Mail;
import cn.hutool.extra.mail.MailAccount;
import com.lee.onstage.model.dto.EmailDto;
import com.lee.onstage.service.EmailService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * 邮件服务
 */
@Service
@Slf4j
public class EmailServiceImpl implements EmailService {
    /**
     * 邮箱号
     */
    @Value("${spring.mail.username}")
    private String email_account;
    @Resource
    JavaMailSender javaMailSender;
    @Resource
    TemplateEngine templateEngine;
    @Override
    public void sendEmail(EmailDto emailDto) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            int size = emailDto.getEmailAccounts().size();
            message.setTo(emailDto.getEmailAccounts().toArray(new String[size]));
            message.setSubject(emailDto.getSubject());
            message.setText(emailDto.getContent());
            javaMailSender.send(message);
        }catch (Exception e){
            log.info("email to {} failed to be send,reason:{}",emailDto.getEmailAccounts(),e.getLocalizedMessage());
        }

    }

    @Override
    public void sendHtmlEmail(EmailDto emailDto) {
        try{
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            Context context = new Context();
            context.setVariables(emailDto.getContentMap());
            String process = templateEngine.process(emailDto.getTemplate(), context);
            mimeMessageHelper.setFrom(email_account);
            mimeMessageHelper.setTo(emailDto.getEmailAccounts().toArray(new String[0]));
            mimeMessageHelper.setSubject(emailDto.getSubject());
            mimeMessageHelper.setText(process, true);
            javaMailSender.send(mimeMessage);
        }catch (Exception e){
            log.info("email to {} failed to be send reason:{}",emailDto.getEmailAccounts(),e.getLocalizedMessage());

        }

    }
}
