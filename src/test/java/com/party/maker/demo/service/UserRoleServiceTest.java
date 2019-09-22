package com.party.maker.demo.service;

import com.party.maker.demo.domain.UserRole;
import com.party.maker.demo.domain.UserRoleType;
import com.party.maker.demo.dto.UserRolesDto;
import com.party.maker.demo.exceptions.UserNotFoundException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Sql("/test-data.sql")
public class UserRoleServiceTest {
    @Autowired
    UserRoleService userRoleService;

    @Rule
    final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void findByIdTest() throws UserNotFoundException {
        UserRolesDto rolesDto = userRoleService.findById(1L);
        assertEquals(UserRoleType.ADMIN, rolesDto.getRole());
    }

    @Test
    public void addUserTest(){
        UserRolesDto rolesDto = new UserRolesDto();
        UserRole role = userRoleService.addUserRole(rolesDto);
        assertNotNull(role);
    }

    @Test/*(expected = com.party.maker.demo.exceptions.UserNotFoundException.class)*/
    public void UserNotFoundExceptionTest() throws UserNotFoundException {
        expectedException.expect(UserNotFoundException.class);
        userRoleService.findById(15L);

    }
}
