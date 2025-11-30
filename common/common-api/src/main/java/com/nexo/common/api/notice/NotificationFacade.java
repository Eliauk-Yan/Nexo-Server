package com.nexo.common.api.notice;

import com.nexo.common.api.notice.response.NotificationResponse;

/**
 * @classname NotificationFacade
 * @description 通知服务对外接口（供其他模块调用）
 * @date 2025/11/28 15:45
 * @created by YanShijie
 */
public interface NotificationFacade {

    /**
     * 发送短信验证码
     * @param phone 手机号
     * @param code 验证码
     * @return 是否发送成功
     */
    NotificationResponse sendSmsVerifyCode(String phone, String code);
}
