package com.unfrost.admin.dto;

import com.unfrost.common.base.dto.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-26 11:34
 */
@Getter
@Setter
@NoArgsConstructor
public class UserInfoDTO extends BaseDTO {
    private String name;

    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
