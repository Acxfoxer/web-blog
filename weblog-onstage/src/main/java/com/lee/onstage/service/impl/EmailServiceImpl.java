package com.lee.onstage.service.impl;

import cn.hutool.extra.mail.Mail;
import cn.hutool.extra.mail.MailAccount;
import com.lee.onstage.model.dto.EmailDto;
import com.lee.onstage.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 邮件服务
 */
@Service
@Slf4j
@ConfigurationProperties(prefix = "spring.email")
public class EmailServiceImpl implements EmailService {
    private String emailAccount;
    private String userName;
    @Override
    public void sendEmail(EmailDto emailDto) {
        MailAccount account = new MailAccount();
        account.setFrom(emailAccount);
        account.setUser(userName);
        try{
            int size = emailDto.getEmailAccounts().size();
            Mail.create(account)
                    .setTos(emailDto.getEmailAccounts().toArray(new String[size]))
                    .setTitle(emailDto.getSubject())
                    .setContent(emailDto.getContent())
                    .setHtml(true)
                    .setUseGlobalSession(false)
                    .send();
        }catch (Exception e){
            log.info("email to {} failed to be sen,reason:{}",emailDto.getEmailAccounts(),e);
        }

    }

    @Override
    public void sendHtmlEmail(EmailDto emailDto) {

    }
}
