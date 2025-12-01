package com.nexo.auth.controller;

import com.nexo.auth.service.AuthService;
import com.nexo.common.web.vo.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @classname AuthController
 * @description 认证控制类
 * @date 2025/12/01 18:01
 * @created by YanShijie
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/verifyCode")
    public Result<Boolean> sendSmsVerifyCode(String phone) {
        return Result.success(authService.sendSmsVerifyCode(phone));
    }

}
