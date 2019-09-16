package com.party.maker.demo.controller;

import com.party.maker.demo.domain.User;
import com.party.maker.demo.dto.UserDto;
import com.party.maker.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public User createUser(@RequestBody UserDto userDto) throws Throwable {
        return userService.addUser(userDto);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> findAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/hosts")
    public ResponseEntity<List<UserDto>> findHosts(){
        return new ResponseEntity<>(userService.getAllHosts(), HttpStatus.OK);
    }

    @GetMapping("/clients")
    public ResponseEntity<List<UserDto>> findClients(){
        return new ResponseEntity<>(userService.getAllClients(), HttpStatus.OK);
    }

    @GetMapping("/admins")
    public ResponseEntity<List<UserDto>> findAdmins(){
        return new ResponseEntity<>(userService.getAllAdmins(), HttpStatus.OK);
    }
}
