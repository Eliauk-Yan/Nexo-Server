package com.nexo.business.notice.infrastructure.adapter;

import com.nexo.common.sms.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @classname SmsAdapter
 * @description 短信服务适配器（基础设施层实现领域层接口）
 * @date 2025/11/28 15:45
 * @created by YanShijie
 */
@Component
@RequiredArgsConstructor
public class SmsAdapter {

    private final SmsService smsService;

    /**
     * 发送短信
     * @param target 目标（手机号）
     * @param content 短信内容（验证码）
     */
    public void send(String target, String content) {
        smsService.sendSmsVerifyCode(target, content);
    }
}

