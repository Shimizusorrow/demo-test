package com.unfrost.admin.exception;

import com.unfrost.common.exception.BusinessException;
import lombok.*;

/**
 * @author Shimizu
 * @description 注册异常
 * @date 2021-04-08 14:45
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class RegisteredUserException extends BusinessException {
    public RegisteredUserException(String message) {
        super(message);
    }
}
