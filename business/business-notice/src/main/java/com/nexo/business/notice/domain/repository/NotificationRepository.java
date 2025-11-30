package com.nexo.business.notice.domain.repository;

import com.nexo.business.notice.domain.entity.Notification;

/**
 * @classname NotificationRepository
 * @description 通知仓储接口（领域层）
 * @date 2025/11/28 15:45
 * @created by YanShijie
 */
public interface NotificationRepository {

    /**
     * 保存通知
     * @param notification 通知实体
     */
    void save(Notification notification);
}

