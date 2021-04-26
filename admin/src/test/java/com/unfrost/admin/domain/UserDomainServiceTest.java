package com.unfrost.admin.domain;

import com.unfrost.admin.dto.UserInfoDTO;
import com.unfrost.admin.enums.GenderEnum;
import com.unfrost.admin.enums.RoleEnum;
import com.unfrost.admin.repo.UserRepo;
import com.unfrost.common.base.dto.DtoConverterProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("junit")
@Import(DtoConverterProvider.class)
class UserDomainServiceTest {
    @Autowired
    private UserRepo userRepo;

    @Test
    void notnull() {
        assertNotNull(userRepo);
    }

    @Test
    void find(){
        userRepo.save(new User("1","1", RoleEnum.ADMIN, GenderEnum.MALE,"1"));
        List<UserInfoDTO> userInfo = userRepo.findUserInfo();
        assertEquals("1",userInfo.get(0).getName());
    }

}