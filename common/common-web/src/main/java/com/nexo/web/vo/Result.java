package com.nexo.web.vo;

/**
 * @classname Result
 * @description 统一返回对象
 * @date 2025/11/27 21:01
 * @created by YanShijie
 */
public class Result<T> {

    private String code;

    private Boolean success;

    private String message;

    private T data;

    public Result() {
    }

    public Result(Boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public Result(Boolean success, String code, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.code = code;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(true, "success", "success", data);
    }

    public static <T> Result<T> error(String code, String message) {
        return new Result<>(false, code, message, null);
    }
}
