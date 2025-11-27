package com.nexo.common.sms;

public interface SmsService {

    /**
     * 调用第三方服务发送短信验证码
     * @param phone 手机号
     * @param code 验证码
     */
    void sendSmsVerifyCode(String phone, String code);

}
