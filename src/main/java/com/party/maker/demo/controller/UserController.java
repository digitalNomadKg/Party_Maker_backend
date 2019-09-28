package com.party.maker.demo.controller;

import com.party.maker.demo.domain.User;
import com.party.maker.demo.dto.UserDto;
import com.party.maker.demo.exceptions.UserNotFoundException;
import com.party.maker.demo.repository.UserRepository;
import com.party.maker.demo.service.MyUserDetailsService;
import com.party.maker.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final MyUserDetailsService myUserDetailsService;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository, MyUserDetailsService myUserDetailsService) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.myUserDetailsService = myUserDetailsService;
    }

    @PostMapping(value = "/add")
    @PreAuthorize("hasRole('ADMIN')")
    public User create(@RequestBody UserDto userDto) throws Throwable {
        return userService.addUser(userDto);
    }

/*    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public UserDto registerUser(@RequestBody UserDto userDto){
        return userService.register(userDto);
    }*/

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDetails loginUser(@Valid @RequestBody UserDto userDto){
        User user2 = userRepository.findByUserName(userDto.getUserName());
        if (user2 == null) {
            throw new UsernameNotFoundException("User name " + userDto.getUserName() + " not found");
        }
        return new org.springframework.security.core.userdetails.User(userDto.getUserName(), userDto.getPassword(),
                myUserDetailsService.getGrantedAuthorities(user2));
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        return userService.logout(request,response);
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserDto>> findAll(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/hosts")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserDto>> findHosts(){
        return new ResponseEntity<>(userService.getAllHosts(), HttpStatus.OK);
    }

    @GetMapping("/clients")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserDto>> findClients(){
        return new ResponseEntity<>(userService.getAllClients(), HttpStatus.OK);
    }

    @GetMapping("/admins")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserDto>> findAdmins(){
        return new ResponseEntity<>(userService.getAllAdmins(), HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> updateById(@PathVariable Long id){
        if(userService.getUserById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        UserDto userDto = userService.getUserById(id);
        return new ResponseEntity<>(userService.editUser(userDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity deleteById(@PathVariable Long id) {
        if(userService.getUserById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.deleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
