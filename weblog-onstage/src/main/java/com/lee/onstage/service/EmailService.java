package com.lee.onstage.service;

import com.lee.onstage.model.dto.EmailDto;

/**
 * 邮件服务接口
 * @author Acxfoxer
 */
public interface EmailService {
    /**
     * 发送邮件
     * @param emailDto 邮件信息
     */
    void sendEmail(EmailDto emailDto);

    /**
     * 发送HTML邮件
     * @param emailDto 邮件信息
     */
    void sendHtmlEmail(EmailDto emailDto);
}
