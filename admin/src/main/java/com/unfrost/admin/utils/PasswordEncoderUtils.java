package com.unfrost.admin.utils;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-09 08:33
 */
public class PasswordEncoderUtils {
    private static PasswordEncoder encoder = null;

    public static PasswordEncoder getInstanceEncoder() {
        if (Objects.isNull(encoder)) {
            encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        }
        return encoder;
    }
}
