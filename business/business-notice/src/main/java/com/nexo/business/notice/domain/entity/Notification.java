package com.nexo.business.notice.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.nexo.business.notice.domain.constant.NotificationState;
import com.nexo.business.notice.domain.constant.NotificationType;
import com.nexo.common.datasource.domain.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @classname Notification
 * @description 通知领域实体
 * @date 2025/11/28 15:45
 * @created by YanShijie
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("notification")
public class Notification extends BaseEntity {

    /**
     * 通知标题
     */
    @TableField("title")
    private String title;

    /**
     * 通知内容
     */
    @TableField("content")
    private String content;

    /**
     * 通知类型
     */
    @TableField("notify_type")
    private String notifyType;

    /**
     * 发送成功时间
     */
    @TableField("success_time")
    private LocalDateTime successTime;

    /**
     * 目标（手机号、邮箱等）
     */
    @TableField("target")
    private String target;

    /**
     * 通知状态（数据库字段为state）
     */
    @TableField("state")
    private String status;

    /**
     * 创建通知实体
     */
    public static Notification create(NotificationType type, String target, String content) {
        Notification notification = new Notification();
        notification.setNotifyType(type.getCode());
        notification.setTarget(target);
        notification.setContent(content);
        notification.setStatus(NotificationState.PENDING.getCode());
        notification.setTitle(type.getDesc());
        return notification;
    }

    /**
     * 标记为发送中
     */
    public void markAsSending() {
        this.status = NotificationState.SENDING.getCode();
    }

    /**
     * 标记为发送成功
     */
    public void markAsSuccess() {
        this.status = NotificationState.SUCCESS.getCode();
        this.successTime = LocalDateTime.now();
    }

    /**
     * 标记为发送失败
     */
    public void markAsFailed() {
        this.status = NotificationState.FAILED.getCode();
    }
}
