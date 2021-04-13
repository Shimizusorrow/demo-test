package com.unfrost.admin.domain;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unfrost.admin.enums.GenderEnum;
import com.unfrost.admin.enums.RoleEnum;
import com.unfrost.admin.utils.PasswordEncoderUtils;
import com.unfrost.common.base.entity.BaseEntity;
import com.unfrost.common.base.entity.LifeState;
import com.unfrost.common.exception.BusinessException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Collection;
import java.util.Objects;

/**
 * @author Shimizu
 * @description 用户实体
 * @date 2021-04-07 14:44
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ApiModel("用户实体")
public class User extends BaseEntity implements UserDetails {
    @ApiModelProperty("用户名称")
    private String name;

    @ApiModelProperty("账号")
    private String username;

    @ApiModelProperty("密码")
    @JsonIgnore
    private String password;

    @ApiModelProperty("权限")
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @ApiModelProperty("性别")
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @ApiModelProperty("邮箱")
    private String email = "";

    @ApiModelProperty("头像图片")
    private String avatarImage = "";

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * 更新
     */
    public User(String name, String password, RoleEnum role, GenderEnum gender, String email) {
        setName(name);
        setPassword(password);
        setEmail(email);
        this.role = role;
        this.gender = gender;
    }

    /**
     * 新增
     */
    public User(String name, String username, String password, RoleEnum role, GenderEnum gender, String email) {
        this(name, password, role, gender, email);
        setUsername(username);
    }

    public void setEmail(String email) {
        if (StrUtil.containsBlank(email)) {
            throw new BusinessException("邮箱中带有空格");
        }
        this.email = email;
    }

    public void setName(String name) {
        if (StrUtil.containsBlank(name)) {
            throw new BusinessException("名称不许带空格");
        }
        this.name = name;
    }

    public void setUsername(String username) {
        if (StrUtil.containsBlank(username)) {
            throw new BusinessException("账号不许带空格");
        }
        this.username = username;
    }

    public void setPassword(String password) {
        if (StrUtil.containsBlank(password)) {
            throw new BusinessException("密码不允许为空");
        }
        this.password = PasswordEncoderUtils.getInstanceEncoder()
                .encode(password);
    }

    public static User initAdmin() {
        return new User("清水忧", "admin", PasswordEncoderUtils.getInstanceEncoder()
                .encode("1"), RoleEnum.SUPER_ADMIN, GenderEnum.MALE, "1047791704@qq.com");
    }

    /**
     * 删除用户
     */
    public void del() {
        this.beStopped();
    }

    /**
     * 新增用户
     *
     * @param addUserVO 新增用户值对象
     * @param role      权限
     */
    public User(AddUserVO addUserVO, RoleEnum role) {
        this(addUserVO.getName(), addUserVO.getUsername(), addUserVO.getPassword(), role, addUserVO.getGender(), addUserVO.getEmail());
    }

    /**
     * 更新用户
     *
     * @param updateUserVO
     * @param role
     */
    public User(UpdateUserVO updateUserVO, RoleEnum role) {
        this(updateUserVO.getName(), updateUserVO.getPassword(), role, updateUserVO.getGender(), updateUserVO.getEmail());
        this.setId(updateUserVO.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), username);
    }
}
