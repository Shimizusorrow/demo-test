package com.unfrost.admin.repo;

import com.unfrost.admin.domain.User;
import com.unfrost.admin.enums.RoleEnum;
import com.unfrost.common.exception.BusinessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
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

    default User findByUsernameThrow(String username) {
        return findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("用户不存在!"));
    }

    default User findByIdThrow(String id) {
        return findById(id).orElseThrow(() -> new BusinessException("用户不存在"));
    }

    /**
     * 查询所有正常的用户
     *
     * @return
     */
    @Query(nativeQuery = true,
            value = "select * from user u where u.life_state = 'RUNNING'")
    List<User> findAllRunning();

    /**
     * 判断是否存在相同的名称
     *
     * @param name
     * @return
     */
    boolean existsByName(String name);

    default void existsByNameThrow(String name) {
        if (existsByName(name)) {
            throw new BusinessException("用户名已存在!");
        }
    }

    /**
     * 判断是否存在相同的账户
     *
     * @param username
     * @return
     */
    boolean existsByUsername(String username);

    default void existsByUsernameThrow(String username){
        if (existsByUsername(username)) {
            throw new BusinessException("账号已存在!");
        }
    }
}
