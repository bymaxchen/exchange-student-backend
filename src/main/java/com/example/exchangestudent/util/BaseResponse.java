package com.example.exchangestudent.util;

import com.example.exchangestudent.emums.ErrorEnums;
import lombok.Data;

@Data
public class BaseResponse<T> {

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    private static final String SUCCESS_MSG = "SUCCESS";

    private static final int SUCCESS_CODE = 0;

    private static final Object DATA_OBJ = new Object();

    public BaseResponse() {
    }

    public BaseResponse(int code, String msg, T data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    public static BaseResponse<Object> ok() {
        return ok(SUCCESS_CODE, SUCCESS_MSG);
    }

    public static BaseResponse<Object> ok(int code, String message) {
        return new BaseResponse<>(code, message, DATA_OBJ);
    }

    public static <T> BaseResponse<T> ok(T data) {
        return new BaseResponse<>(SUCCESS_CODE, SUCCESS_MSG, data);
    }

    public static <T> BaseResponse<T> ok(int code, String message, T data) {
        return new BaseResponse<>(code, message, data);
    }

    public static <T> BaseResponse<T> error(ErrorEnums error, T data) {
        return error(error.getCode(), error.getMsg(), data);
    }

    public static BaseResponse<Object> error(int code, String message) {
        return new BaseResponse<>(code, message, DATA_OBJ);
    }

    public static <T> BaseResponse<T> error(int code, String message, T data) {
        return new BaseResponse<>(code, message, data);
    }
}