package com.nexo.business.notice.interfaces.facade;

import com.nexo.business.notice.application.dto.SendVerifyCodeDTO;
import com.nexo.business.notice.application.service.NotificationApplicationService;
import com.nexo.common.api.notice.NotificationFacade;
import com.nexo.common.api.notice.response.NotificationResponse;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @classname NotificationFacadeImpl
 * @description 通知模块对外接口实现（接口层）
 * @date 2025/11/28 17:34
 * @created by YanShijie
 */
@DubboService(version = "1.0.0")
public record NotificationFacadeImpl(
        NotificationApplicationService notificationApplicationService) implements NotificationFacade {

    @Override
    public NotificationResponse sendSmsVerifyCode(String phone, String code) {
        SendVerifyCodeDTO dto = new SendVerifyCodeDTO();
        dto.setPhone(phone);
        dto.setCode(code);
        return notificationApplicationService.sendSmsVerifyCode(dto);
    }
}
