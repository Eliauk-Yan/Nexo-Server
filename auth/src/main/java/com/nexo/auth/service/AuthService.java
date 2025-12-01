package com.nexo.auth.service;

public interface AuthService {

    /**
     * 发送短信验证码
     * @param phone 手机号
     * @return 发送结果
     */
    Boolean sendSmsVerifyCode(String phone);

}
