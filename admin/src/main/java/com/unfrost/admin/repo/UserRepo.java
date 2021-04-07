package com.unfrost.admin.repo;

import com.unfrost.admin.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-07 16:57
 */
public interface UserRepo extends JpaRepository<User, String> {
}
