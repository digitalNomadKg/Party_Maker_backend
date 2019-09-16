package com.party.maker.demo.util;

import com.party.maker.demo.domain.User;
import com.party.maker.demo.dto.UserDto;
import com.party.maker.demo.service.UserService;

public class UserAndUserDtoCoverter {
    private UserService userService;
    private RoleFactory roleFactory;

    public UserDto convertUserToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserID(user.getUserID());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPassword(user.getPassword());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setEmail(user.getEmail());
        userDto.setCity(user.getFirstName());
        userDto.setCountry(user.getCountry());
        userDto.setDateOfBirth(user.getDateOfBirth());
        userDto.setUserName(user.getUserName());
        userDto.setCreatedDate(user.getCreatedDateTime());
        userDto.setUpdatedDate(user.getUpdatedDateTime());
        userDto.setRoleId(user.getRole().getRoleID());
        return userDto;
    }

    public User convertUserDtoToUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setCity(userDto.getCity());
        user.setCountry(userDto.getCountry());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setCreatedDateTime(userService.defineCreatedDate(userDto));
        user.setUpdatedDateTime(userDto.getUpdatedDate());
        user.setUserName(userDto.getUserName());
        user.setRole(roleFactory.assignRoleFactory(userDto.getRoleId()));
        return user;
    }

}

