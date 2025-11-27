package com.nexo.auth.interfaces.controller;

import com.nexo.web.vo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @classname AuthController
 * @description 认证控制器
 * @date 2025/11/27 20:53
 * @created by YanShijie
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/sendCaptcha")
    public Result<Boolean> sendCaptcha(String phone) {
        return Result.success(null);
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
