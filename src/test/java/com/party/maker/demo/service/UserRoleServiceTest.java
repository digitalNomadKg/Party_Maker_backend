package com.party.maker.demo.service;

import com.party.maker.demo.domain.UserRoleType;
import com.party.maker.demo.dto.UserRolesDto;
import com.party.maker.demo.exceptions.UserNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRoleServiceTest {
    @Autowired
    UserRoleService userRoleService;

    @Test
    public void findByIdTest() throws UserNotFoundException {
        UserRolesDto rolesDto = userRoleService.findById(1L);
        assertEquals(UserRoleType.ADMIN, rolesDto.getRole());
    }
}
