package com.nexo.common.sms.impl;

import com.aliyun.sdk.service.dypnsapi20170525.AsyncClient;
import com.aliyun.sdk.service.dypnsapi20170525.models.SendSmsVerifyCodeRequest;
import com.aliyun.sdk.service.dypnsapi20170525.models.SendSmsVerifyCodeResponseBody;
import com.nexo.common.sms.SmsService;
import com.nexo.common.sms.config.SmsProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @classname SmsServiceImpl
 * @description 短信服务实现类
 * @date 2025/11/29 17:05
 * @created by YanShijie
 */
@Slf4j
@RequiredArgsConstructor
public class SmsServiceImpl implements SmsService {

    private final AsyncClient asyncClient;

    private final SmsProperties properties;


    @Override
    public void sendSmsVerifyCode(String phone, String code) {
        // 1. 创建发送短信验证码的请求参数
        SendSmsVerifyCodeRequest sendSmsVerifyCodeRequest = SendSmsVerifyCodeRequest.builder()
                .signName(properties.getSignName())
                .templateCode(properties.getTemplateCode())
                .phoneNumber(phone)
                .templateParam("{code: " + code + ",min: 5}")
                .build();

        // 2. 发送短信验证码
        asyncClient.sendSmsVerifyCode(sendSmsVerifyCodeRequest)
                .whenCompleteAsync((response, throwable) -> {
                    // 2.1 发送失败
                    if (throwable != null) {
                        log.error("[验证码短信发送失败] phone={}, code={}, error={}", phone, code, throwable.getMessage(), throwable);
                    }
                    // 2.2 发送成功
                    SendSmsVerifyCodeResponseBody body = response.getBody();
                    if ("OK".equalsIgnoreCase(body.getCode())) {
                        log.info("[验证码短信发送成功] phone={}, requestId={}", phone, body.getRequestId());
                    } else {
                        log.warn("[验证码短信业务失败] phone={}, code={}, message={}", phone, body.getCode(), body.getMessage());
                    }
                });
    }
}
