package com.unfrost.common.hander;

import com.unfrost.common.exception.BusinessException;
import com.unfrost.common.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-30 16:12
 */
@RestControllerAdvice
public class RestExceptionHandler {

//    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(BusinessException.class)
    public ResultVO businessExceptionHandler(Exception e, HttpServletRequest request) {
        return new ResultVO(e.getMessage(), String.valueOf(HttpStatus.METHOD_NOT_ALLOWED.value()));
    }
}
