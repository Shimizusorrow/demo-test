package com.unfrost.admin.domain;

import com.unfrost.admin.enums.GenderEnum;
import com.unfrost.admin.enums.RoleEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-10 08:39
 */
@Data
@ApiModel("新增用户")
public class AddUserVO {
    @ApiModelProperty("用户名称")
    private String name;

    @ApiModelProperty("账号")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("性别")
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @ApiModelProperty("邮箱")
    private String email = "";
}
