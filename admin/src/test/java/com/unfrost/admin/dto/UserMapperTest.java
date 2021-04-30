package com.unfrost.admin.dto;

import com.unfrost.admin.domain.User;
import com.unfrost.admin.domain.UserMapper;
import com.unfrost.admin.enums.GenderEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * map
 */
class UserMapperTest {

    private UserMapper mapper = UserMapper.INSTANCE;

    @Test
    void notNull() {
        assertNotNull(mapper);
    }

    @Test
    void from() {
        User user = new User();
        user.setName("张三");
        user.setEmail("123");
        user.setGender(GenderEnum.MALE);
        user.setUsername("233");
        UserInfoDTO infoDTO = mapper.infoDtoTransform(user);
        assertNotNull(infoDTO);
        assertEquals(user.getName(), infoDTO.getName());
        assertEquals(user.getUsername(), infoDTO.getUsername());
        assertEquals(user.getGender(), infoDTO.getGender());
        assertEquals(user.getEmail(), infoDTO.getEmail());
    }


}