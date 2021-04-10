package com.unfrost.admin.domain;

import com.unfrost.admin.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Shimizu
 * @description 新增用户以及更新用户的操作
 * @date 2021-04-10 08:27
 */
@Service
@AllArgsConstructor
public class UserDomainService {
    private final UserRepo userRepo;

    public User save(User user) {
        return userRepo.save(user);
    }

    public User update(User user) {
        return userRepo.save(user);
    }

    public User del(User user) {
        if (user.isRunning()) {
            user.del();
        }
        return userRepo.save(user);
    }
}
