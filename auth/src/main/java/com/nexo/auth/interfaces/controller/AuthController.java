package com.nexo.auth.interfaces.controller;

import com.nexo.common.api.notice.NotificationFacade;
import com.nexo.common.api.notice.response.NotificationResponse;
import com.nexo.web.vo.Result;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @classname AuthController
 * @description 认证控制器
 * @date 2025/11/27 20:53
 * @created by YanShijie
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @DubboReference
    private NotificationFacade notificationFacade;

    /**
     * 发送验证码
     * @param phone 手机号
     * @return 是否发送成功
     */
    @PostMapping("/sendCaptcha")
    public Result<Boolean> sendCaptcha(@RequestParam String phone) {
        phone = "15114785913";
        // 生成6位随机验证码
        String code = String.format("%06d", new Random().nextInt(1000000));
        
        // 调用notice服务发送验证码
        NotificationResponse response = notificationFacade.sendSmsVerifyCode(phone, code);

        return Result.success(response.getSuccess());
    }

    @PostMapping("/login")
    public Result<Void> login() {
        return Result.success(null);
    }

    @PostMapping("/register")
    public Result<Void> register() {
        return Result.success(null);
    }

    @PostMapping("/logout")
    public Result<Void> logout() {
        return Result.success(null);
    }

}
