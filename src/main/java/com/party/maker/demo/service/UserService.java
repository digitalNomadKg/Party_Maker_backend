package com.party.maker.demo.service;

import com.party.maker.demo.domain.User;
import com.party.maker.demo.domain.UserRoleType;
import com.party.maker.demo.dto.UserDto;
import com.party.maker.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(UserDto userDto){
        User user = convertUserDtoToUser(userDto);
        return userRepository.save(user);
    }

    private LocalDateTime defineCreatedDate(UserDto userDto){
        User user = getUserByUsername(userDto);
        if(user == null){
            return LocalDateTime.now();
        }
        return user.getCreatedDateTime();
    }

    private User getUserByUsername(UserDto userDto){
        List<User> users = userRepository.findAll();
        for (User user : users){
            if(userDto.getUserName().equals(user.getUserName())){
                return user;
            }
        }
        return null;
    }

    public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for(User user: users){
            UserDto userDto = convertUserToUserDto(user);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    public List<UserDto> getAllHosts(){
        List<UserDto> hosts = getAllUsers();
        return getHosts(hosts);
    }

    public List<UserDto> getAllClients(){
        List<UserDto> clients = getAllUsers();
        return getClients(clients);
    }

    public List<UserDto> getAllAdmins(){
        List<UserDto> admins = getAllUsers();
        return getAdminUsers(admins);
    }
    private List<UserDto> getHosts(List<UserDto> userDtos){
        List<UserDto> hostList = new ArrayList<>();
        for(UserDto dto: userDtos){
            if(dto.getRole().getName().equalsIgnoreCase(String.valueOf(UserRoleType.HOST))){
                hostList.add(dto);
            }
        }
        return hostList;
    }

    private List<UserDto> getClients(List<UserDto> userDtos){
        List<UserDto> clientList = new ArrayList<>();
        for(UserDto dto: userDtos){
            if(dto.getRole().getName().equalsIgnoreCase(String.valueOf(UserRoleType.CLIENT))){
                clientList.add(dto);
            }
        }
        return clientList;
    }

    private List<UserDto> getAdminUsers(List<UserDto> userDtos){
        List<UserDto> adminList = new ArrayList<>();
        for(UserDto dto: userDtos){
            if(dto.getRole().getName().equalsIgnoreCase(String.valueOf(UserRoleType.ADMIN))){
                adminList.add(dto);
            }
        }
        return adminList;
    }

    private UserDto convertUserToUserDto(User user) {
        UserDto userDto = new UserDto();
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
        return userDto;
    }

    private User convertUserDtoToUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setCity(userDto.getCity());
        user.setCountry(userDto.getCountry());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setCreatedDateTime(defineCreatedDate(userDto));
        user.setUpdatedDateTime(userDto.getUpdatedDate());
        user.setRole(userDto.getRole());
        return user;
    }
}
