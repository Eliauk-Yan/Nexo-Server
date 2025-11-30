create database nexo;

use nexo;

DROP TABLE IF EXISTS `notification`;

CREATE TABLE `notification`
(
    id                BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    title             varchar(512) charset utf8mb3 null comment '通知标题',
    content           text charset utf8mb3         null comment '通知内容',
    notify_type       varchar(128) charset utf8mb3 null comment '通知类型',
    success_time      datetime                     null comment '发送成功时间',
    target            varchar(256) charset utf8mb3 null comment '接收地址',
    state             varchar(128) charset utf8mb3 null comment '状态',
    created_at        DATETIME(3)                  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    updated_at        DATETIME(3)                  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    deleted           TINYINT(1)                   NOT NULL DEFAULT 0 COMMENT '逻辑删除：0=正常，1=已删除',
    version           INT UNSIGNED                 NOT NULL DEFAULT 1 COMMENT '乐观锁版本号'
)
    COMMENT ='通知表';

