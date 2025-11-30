package com.nexo.business.notice.domain.service;

import com.nexo.business.notice.domain.entity.Notification;
import com.nexo.business.notice.domain.constant.NotificationType;

/**
 * @classname NotificationDomainService
 * @description 通知领域服务
 * @date 2025/11/28 15:45
 * @created by YanShijie
 */
public interface NotificationDomainService {

    /**
     * 创建并发送通知
     * @param type 通知类型
     * @param target 目标（手机号、邮箱等）
     * @param content 通知内容
     * @return 通知实体
     */
    Notification createAndSendNotification(NotificationType type, String target, String content);
}

