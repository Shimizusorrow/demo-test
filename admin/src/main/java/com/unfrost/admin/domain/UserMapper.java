package com.unfrost.admin.domain;

import com.unfrost.admin.dto.UserInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-30 14:21
 */
//@Mapper
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    /**
     * 转换
     *
     * @param user
     * @return
     */
//    根据指定名称转换
//    @BeanMapping(ignoreByDefault = true)
//    @Mappings({
//            @Mapping(source = "user.name", target = "name")
//    })
    UserInfoDTO infoDtoTransform(User user);
}
