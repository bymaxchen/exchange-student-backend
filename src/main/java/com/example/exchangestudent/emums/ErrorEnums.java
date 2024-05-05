package com.example.exchangestudent.emums;

import lombok.AllArgsConstructor;
import lombok.Getter;

public enum ErrorEnums {

    /**
     * common
     */
    UN_KNOW_PARAM_ERROR(171010001, "未知的参数错误"),
    UN_KNOW_ERROR(171010002, "未知的错误"),
    ;

    private final Integer code;
    private final String msg;

    // Private no-args constructor to resolve conflict with Lombok's @AllArgsConstructor
    private ErrorEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
