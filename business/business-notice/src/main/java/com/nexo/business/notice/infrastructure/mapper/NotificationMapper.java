package com.nexo.business.notice.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nexo.business.notice.domain.entity.Notification;
import org.apache.ibatis.annotations.Mapper;

/**
 * @classname NotificationMapper
 * @description 通知Mapper接口
 * @date 2025/11/28 15:45
 * @created by YanShijie
 */
@Mapper
public interface NotificationMapper extends BaseMapper<Notification> {

}
