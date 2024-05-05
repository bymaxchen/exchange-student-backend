package com.example.exchangestudent.exception;

import com.example.exchangestudent.emums.ErrorEnums;
import com.example.exchangestudent.util.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.BindException;

@RestControllerAdvice
public class exceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {
            HttpMessageNotReadableException.class, //参数解析失败
    })
    public BaseResponse<Object> handleClientException(Exception e) {
        return BaseResponse.error(ErrorEnums.UN_KNOW_PARAM_ERROR, e.getMessage());
    }
}
