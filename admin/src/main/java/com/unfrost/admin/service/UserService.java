package com.unfrost.admin.service;

import com.unfrost.admin.domain.User;
import com.unfrost.admin.repo.UserRepo;
import com.unfrost.common.exception.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-09 08:12
 */
@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("用户不存在!"));
        if (!user.isRunning()) {
            throw new BusinessException(String.format("[%s]：用户已注销!", username));
        }
        return user;
    }
}
