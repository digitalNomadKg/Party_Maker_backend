package com.party.maker.demo.controller;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.party.maker.demo.domain.UserRole;
import com.party.maker.demo.domain.UserRoleType;
import com.party.maker.demo.dto.UserRolesDto;
import com.party.maker.demo.exceptions.UserNotFoundException;
import junit.runner.Version;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserRoleController.class)
public class UserRoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private UserRoleController roleController;
    private ResponseEntity<UserRole> responseEntity;

    @Test
    public void findUserRoleById() throws UserNotFoundException, Exception {
       UserRolesDto rolesDto = new UserRolesDto();
        given(roleController.findUserRoleById(rolesDto.getRoleID())).willReturn(new ResponseEntity<>(rolesDto, HttpStatus.OK));
        mockMvc.perform(get("/user/role/1")).andExpect(status().isOk());
    }

    @Test
    public void createRole()throws Exception {
        UserRolesDto rolesDto = new UserRolesDto();
        rolesDto.setRoleID(9L);
        rolesDto.setRole(UserRoleType.ADMIN);

        mockMvc.perform(post("/user/role")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(rolesDto)))
                .andExpect(status().isCreated());
    }
}
