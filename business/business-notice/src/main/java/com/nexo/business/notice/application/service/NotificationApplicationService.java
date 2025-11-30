package com.nexo.business.notice.application.service;

import com.nexo.business.notice.application.dto.SendVerifyCodeDTO;
import com.nexo.common.api.notice.response.NotificationResponse;

/**
 * @classname NotificationApplicationService
 * @description 通知应用服务
 * @date 2025/11/28 15:45
 * @created by YanShijie
 */
public interface NotificationApplicationService {

    /**
     * 发送短信验证码
     * @param dto 发送短信验证码的参数
     * @return 发送结果
     */
    NotificationResponse sendSmsVerifyCode(SendVerifyCodeDTO dto);
}

