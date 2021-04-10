package com.unfrost.admin.domain;

import com.unfrost.admin.enums.GenderEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-10 08:40
 */
@Data
public class UpdateUserVO {
    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("用户名称")
    private String name;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("性别")
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @ApiModelProperty("邮箱")
    private String email = "";
}
