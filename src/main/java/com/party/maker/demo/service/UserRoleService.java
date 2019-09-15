package com.party.maker.demo.service;

import com.party.maker.demo.domain.UserRole;
import com.party.maker.demo.dto.UserRolesDto;
import com.party.maker.demo.exceptions.UserNotFoundException;
import com.party.maker.demo.repository.UserRoleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserRoleService {
    final UserRoleRepository userRoleRepository;

    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public UserRole addUserRole(UserRolesDto userRolesDto){
        UserRole userRole = convertUserRoleDtotoUserRole(userRolesDto);
        return userRoleRepository.save(userRole);
    }

    private UserRole convertUserRoleDtotoUserRole(UserRolesDto userRolesDto) {
        UserRole userRole = new UserRole();
        userRole.setRoleID(userRolesDto.getRoleID());
        userRole.setName(userRolesDto.getName());
        userRole.setStartDate(LocalDate.now());
        return userRole;
    }

    public UserRolesDto findById(Long id) throws UserNotFoundException {
        if(userRoleRepository.findById(id).isPresent()){
            UserRole userRole = userRoleRepository.findById(id).get();
            UserRolesDto userRolesDto = convertUserRoleToUserRolesDto(userRole);
            return userRolesDto;
        }
        throw new UserNotFoundException();
    }

    private UserRolesDto convertUserRoleToUserRolesDto(UserRole userRole) {
        UserRolesDto userRolesDto = new UserRolesDto();
        userRolesDto.setRoleID(userRole.getRoleID());
        userRolesDto.setName(userRole.getName());
        return userRolesDto;
    }
}
