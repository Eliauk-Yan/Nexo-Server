package com.nexo.business.notice.application.service.impl;

import com.nexo.business.notice.application.dto.SendVerifyCodeDTO;
import com.nexo.business.notice.application.service.NotificationApplicationService;
import com.nexo.business.notice.domain.constant.NotificationType;
import com.nexo.business.notice.domain.entity.Notification;
import com.nexo.business.notice.domain.repository.NotificationRepository;
import com.nexo.business.notice.domain.service.NotificationDomainService;
import com.nexo.common.api.notice.response.NotificationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @classname NotificationApplicationServiceImpl
 * @description 通知应用服务实现
 * @date 2025/11/28 15:45
 * @created by YanShijie
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationApplicationServiceImpl implements NotificationApplicationService {

    private final NotificationDomainService notificationDomainService;

    private final NotificationRepository notificationRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public NotificationResponse sendSmsVerifyCode(SendVerifyCodeDTO dto) {

        // 1.使用领域服务创建并发送通知
        Notification notification = notificationDomainService.createAndSendNotification(NotificationType.SMS_VERIFY_CODE, dto.getPhone(), dto.getCode());

        // 2.保存通知记录
        notificationRepository.save(notification);

        // 3. 返回发送结果
        return new NotificationResponse();
    }
}

