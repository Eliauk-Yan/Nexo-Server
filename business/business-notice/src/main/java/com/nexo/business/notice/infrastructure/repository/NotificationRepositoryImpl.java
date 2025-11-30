package com.nexo.business.notice.infrastructure.repository;

import com.nexo.business.notice.domain.entity.Notification;
import com.nexo.business.notice.domain.repository.NotificationRepository;
import com.nexo.business.notice.infrastructure.mapper.NotificationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @classname NotificationRepositoryImpl
 * @description 通知仓储实现（基础设施层）
 * @date 2025/11/28 15:45
 * @created by YanShijie
 */
@Repository
@RequiredArgsConstructor
public class NotificationRepositoryImpl implements NotificationRepository {

    private final NotificationMapper notificationMapper;

    @Override
    public void save(Notification notification) {
        int row = notificationMapper.insert(notification);
        if (row != 1) {
            throw new RuntimeException("保存通知失败");
        }
    }
}

