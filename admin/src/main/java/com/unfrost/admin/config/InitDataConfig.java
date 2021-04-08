package com.unfrost.admin.config;

import com.unfrost.admin.domain.User;
import com.unfrost.admin.enums.RoleEnum;
import com.unfrost.admin.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-08 14:33
 */
@Configuration
@AllArgsConstructor
public class InitDataConfig implements CommandLineRunner {
    private final UserRepo userRepo;

    @Override
    public void run(String... args) {
        initSuperAdmin();
    }

    /**
     * 初始化超级管理员账号
     */
    private void initSuperAdmin() {
        if (!userRepo.existsByRole(RoleEnum.SUPER_ADMIN)) {
            userRepo.save(User.initAdmin());
        }
    }
}
