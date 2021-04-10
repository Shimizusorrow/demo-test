package com.unfrost.admin.service;

import com.unfrost.admin.domain.AddUserVO;
import com.unfrost.admin.domain.UpdateUserVO;
import com.unfrost.admin.domain.User;
import com.unfrost.admin.domain.UserDomainService;
import com.unfrost.admin.enums.RoleEnum;
import com.unfrost.admin.repo.UserRepo;
import com.unfrost.common.exception.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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
    private final UserDomainService userDomainService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepo.findByUsernameThrow(username);
        if (!user.isRunning()) {
            throw new BusinessException(String.format("[%s]：用户已注销!", username));
        }
        return user;
    }

    /**
     * 新增用户
     *
     * @param addUserVO
     * @param role
     * @return
     */
    public User addUser(AddUserVO addUserVO, RoleEnum role) {
        judgeRole(role);
        judgeAddUserVo(addUserVO);
        return userDomainService.save(new User(addUserVO, role));
    }

    /**
     * 删除用户
     *
     * @param id
     */
    public void delUser(String id) {
        User find = userRepo.findByIdThrow(id);
        userDomainService.del(find);
    }

    /**
     * 判断权限
     *
     * @param role 权限
     */
    private void judgeRole(RoleEnum role) {
        if (RoleEnum.SUPER_ADMIN.equals(role)) {
            throw new BusinessException("无法创建超级管理员账户");
        }
    }

    /**
     * 判断新增or更新用户的条件
     *
     * @param name
     * @param username
     */
    private void judgeUserCondition(String name, String username) {
        userRepo.existsByNameThrow(name);
        userRepo.existsByUsernameThrow(username);
    }

    private void judgeAddUserVo(AddUserVO addUserVO) {
        judgeUserCondition(addUserVO.getName(), addUserVO.getUsername());
    }

    private void judgeUpdateUserVO(UpdateUserVO updateUserVO, User user) {
        if (!user.getName().equals(updateUserVO.getName())) {
            userRepo.existsByNameThrow(updateUserVO.getName());
        }
    }

    public User updateUser(UpdateUserVO updateUserVO, RoleEnum role) {
        User find = userRepo.findByIdThrow(updateUserVO.getId());
        judgeUpdateUserVO(updateUserVO, find);
        judgeRole(role);
        return userDomainService.update(new User(updateUserVO, role));
    }
}
