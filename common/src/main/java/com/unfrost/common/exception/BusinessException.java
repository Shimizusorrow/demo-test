package com.unfrost.common.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Shimizu
 * @description 业务异常
 * @date 2021-04-08 14:34
 */
@Getter
@Setter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BusinessException extends RuntimeException {
    private static final String DEFAULT_CODE = "9527";
    private String message;
    private String code;
    private Object data;

    public BusinessException(String message) {
        this(message, DEFAULT_CODE, null);
    }

    public BusinessException(String message, String code, Object data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }
}
