package com.party.maker.demo.service;

import com.party.maker.demo.domain.User;
import com.party.maker.demo.domain.UserRoleType;
import com.party.maker.demo.dto.UserDto;
import com.party.maker.demo.exceptions.UserAlreadyExistsException;
import com.party.maker.demo.repository.UserRepository;
import com.party.maker.demo.util.RoleFactory;
import com.party.maker.demo.util.UserAndUserDtoCoverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private RoleFactory roleFactory = new RoleFactory();
    private UserAndUserDtoCoverter converter = new UserAndUserDtoCoverter();
    public Boolean isExists = true;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(UserDto userDto) throws UserAlreadyExistsException {
        if (userRepository.findByUserName(userDto.getUserName())== null) {
            User user = converter.convertUserDtoToUser(userDto);
            return userRepository.save(user);
        }
        throw new UserAlreadyExistsException("This user already exists");
    }

    public Boolean getIsExists(UserDto userDto) {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (userDto.getUserName().equals(user.getUsername())) {
                return true;
            }
        }
        return false;
    }

/*    public User getUserByUsername(UserDto userDto){
        List<User> users = userRepository.findAll();
        for (User user : users){
            if(userDto.getUsername().equals(user.getUsername())){
                return user;
            }
        }
        return null;
    }*/

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = converter.convertUserToUserDto(user);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    public List<UserDto> getAllHosts() {
        List<UserDto> hosts = getAllUsers();
        return getHosts(hosts);
    }

    public List<UserDto> getAllClients() {
        List<UserDto> clients = getAllUsers();
        return getClients(clients);
    }

    public List<UserDto> getAllAdmins() {
        List<UserDto> admins = getAllUsers();
        return getAdminUsers(admins);
    }

    private List<UserDto> getHosts(List<UserDto> userDtos) {
        List<UserDto> hostList = new ArrayList<>();
        for (UserDto dto : userDtos) {
            if (UserRoleType.HOST.equals(roleFactory.getRoleType(dto.getRoleId()))) {
                hostList.add(dto);
            }
        }
        return hostList;
    }

    private List<UserDto> getClients(List<UserDto> userDtos) {
        List<UserDto> clientList = new ArrayList<>();
        for (UserDto dto : userDtos) {
            if (UserRoleType.CLIENT.equals(roleFactory.getRoleType(dto.getRoleId()))) {
                clientList.add(dto);
            }
        }
        return clientList;
    }

    private List<UserDto> getAdminUsers(List<UserDto> userDtos) {
        List<UserDto> adminList = new ArrayList<>();
        for (UserDto dto : userDtos) {
            if (UserRoleType.ADMIN.equals(roleFactory.getRoleType(dto.getRoleId()))) {
                adminList.add(dto);
            }
        }
        return adminList;
    }

    public LocalDateTime defineCreatedDate(UserDto userDto) {
        User user = new User();
        if (!getIsExists(userDto)) {
            return LocalDateTime.now();
        }
        return user.getCreatedDateTime();
    }

    public UserDto getUserById(Long id) {
        if (userRepository.findById(id).isPresent()) {
            User user = userRepository.findById(id).get();
            return converter.convertUserToUserDto(user);
        }
        isExists = false;
        return null;
    }

    public User editUser(UserDto userDto) {
        User user = converter.convertUserDtoToUser(userDto);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        }
    }

    public String logout(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
