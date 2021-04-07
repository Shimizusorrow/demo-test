package com.unfrost.admin.domain;

import com.unfrost.admin.enums.GenderEnum;
import com.unfrost.admin.enums.RoleEnum;
import com.unfrost.common.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
public class User extends BaseEntity {
    @ApiModelProperty("用户名称")
    private String name;

    @ApiModelProperty("账号")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("权限")
    private RoleEnum role;

    @ApiModelProperty("性别")
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @ApiModelProperty("邮箱")
    private String email;

    public void setName(String name) {

        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username.trim();
    }
}
