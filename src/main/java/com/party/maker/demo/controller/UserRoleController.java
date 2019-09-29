package com.party.maker.demo.controller;

import com.party.maker.demo.domain.UserRole;
import com.party.maker.demo.dto.UserRolesDto;
import com.party.maker.demo.exceptions.UserNotFoundException;
import com.party.maker.demo.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRoleController {
    private final UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping(value = "/role")
    @ResponseStatus(HttpStatus.CREATED)
    public UserRole createRole(@RequestBody UserRolesDto userRolesDto){
        return userRoleService.addUserRole(userRolesDto);
    }

    @GetMapping(value = "/role/{id}")
    public ResponseEntity<UserRole> findUserRoleById (@PathVariable Long id) throws UserNotFoundException {
        return new ResponseEntity(userRoleService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/role/roles")
    public ResponseEntity<List<UserRole>> findAllRoles(){
        return new ResponseEntity(userRoleService.findAll(), HttpStatus.OK);
    }
}
