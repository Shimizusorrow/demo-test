package com.unfrost.admin.utils;

import com.unfrost.admin.domain.User;
import com.unfrost.common.exception.BusinessException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * 获取当前用户的工具类
 *
 * @author Shimizu
 * @description
 * @date 2021-04-13 15:13
 */
public class UserUtils {
    /**
     * 获取当前登录的用户信息
     *
     * @return
     */
    public static Optional<User> authenticated() {
        //通过上下文获取登录凭证
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null &&
                authentication.isAuthenticated() &&
                !(authentication instanceof AnonymousAuthenticationToken)) {
            User user = (User) authentication.getPrincipal();
            return Optional.of(user);
        }
        return Optional.empty();
    }

    /**
     * 获取当前登录的用户信息 并抛出异常
     *
     * @return
     */
    public static User gainUserThrow() {
        return authenticated().orElseThrow(() -> new BusinessException("用户未登录!"));
    }
}
