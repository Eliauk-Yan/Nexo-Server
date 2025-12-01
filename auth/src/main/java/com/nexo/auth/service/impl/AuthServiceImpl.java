package com.nexo.auth.service.impl;

import com.nexo.auth.service.AuthService;
import com.nexo.common.api.notification.NotificationFacade;
import com.nexo.common.api.notification.response.NotificationResponse;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @classname AuthServiceImpl
 * @description 认证相关服务实现类
 * @date 2025/12/01 18:02
 * @created by YanShijie
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    @DubboReference(version = "1.0.0")
    private final NotificationFacade notificationFacade;

    @Override
    public Boolean sendSmsVerifyCode(String phone) {
        // 1. 发送验证码
        NotificationResponse response = notificationFacade.sendSmsVerifyCode(phone);
        // 2. 返回结果
        return response.getSuccess();
    }
}
