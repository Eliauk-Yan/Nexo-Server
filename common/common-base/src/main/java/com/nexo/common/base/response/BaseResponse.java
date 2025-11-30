package com.nexo.common.base.response;

import lombok.Data;

/**
 * @classname BaseResponse
 * @description 响应基类
 * @date 2025/11/30 13:13
 * @created by YanShijie
 */
@Data
public class BaseResponse {

    private Boolean success;

    private String code;

    private String message;

}
