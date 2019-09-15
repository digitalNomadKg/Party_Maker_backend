package com.party.maker.demo.service;

import com.party.maker.demo.domain.User;
import com.party.maker.demo.dto.UserDto;
import com.party.maker.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(UserDto userDto){
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setCity(userDto.getCity());
        user.setCountry(userDto.getCountry());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setCreatedDate(userDto.getCreatedDate());
        user.setUpdatedDate(userDto.getUpdatedDate());
        user.setRole(userDto.getRole());
        return userRepository.save(user);
    }
}
