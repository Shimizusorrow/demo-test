package com.unfrost.admin.repo;

import com.unfrost.admin.domain.User;
import com.unfrost.admin.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-07 16:57
 */
public interface UserRepo extends JpaRepository<User, String> {
    /**
     * 判断是否存在某权限人员
     *
     * @param role
     * @return
     */
    boolean existsByRole(RoleEnum role);

    /**
     * 查询账户
     *
     * @param username
     * @return
     */
    Optional<User> findByUsername(String username);
}
