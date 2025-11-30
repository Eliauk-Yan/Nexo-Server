package com.nexo.business.notice.application.dto;

import lombok.Data;

/**
 * @classname SendVerifyCodeDTO
 * @description 发送验证码DTO
 * @date 2025/11/28 15:45
 * @created by YanShijie
 */
@Data
public class SendVerifyCodeDTO {

    /**
     * 手机号
     */
    private String phone;

    /**
     * 验证码
     */
    private String code;

}

