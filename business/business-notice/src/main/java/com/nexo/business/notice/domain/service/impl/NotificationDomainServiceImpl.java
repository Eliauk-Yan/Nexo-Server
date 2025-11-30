package com.nexo.business.notice.domain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nexo.business.notice.domain.constant.NotificationType;
import com.nexo.business.notice.domain.entity.Notification;
import com.nexo.business.notice.domain.service.NotificationDomainService;
import com.nexo.business.notice.infrastructure.adapter.SmsAdapter;
import com.nexo.business.notice.infrastructure.mapper.NotificationMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @classname NotificationDomainServiceImpl
 * @description 通知领域服务实现
 * @date 2025/11/28 15:45
 * @created by YanShijie
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationDomainServiceImpl extends ServiceImpl<NotificationMapper, Notification> implements NotificationDomainService {

    private final SmsAdapter smsAdapter;

    @Override
    public Notification createAndSendNotification(NotificationType type, String target, String content) {

        // 1. 创建通知实体
        Notification notification = Notification.create(type, target, content);

        // 2. 根据类型发送通知
        if (type == NotificationType.SMS_VERIFY_CODE) {
            sendSmsNotification(notification);
        } else {
            log.warn("不支持的通知类型：{}", type);
            notification.markAsFailed();
        }

        return notification;
    }

    /**
     * 发送短信通知
     */
    private void sendSmsNotification(Notification notification) {
        try {
            notification.markAsSending();
            smsAdapter.send(notification.getTarget(), notification.getContent());
            notification.markAsSuccess();
            log.info("短信发送成功，目标：{}", notification.getTarget());
        } catch (Exception e) {
            log.error("短信发送失败，目标：{}", notification.getTarget(), e);
            notification.markAsFailed();
        }
    }
}

