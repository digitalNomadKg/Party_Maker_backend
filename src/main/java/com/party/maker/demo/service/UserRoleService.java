package com.party.maker.demo.service;

import com.party.maker.demo.domain.UserRole;
import com.party.maker.demo.dto.UserRolesDto;
import com.party.maker.demo.exceptions.UserNotFoundException;
import com.party.maker.demo.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserRoleService {
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public UserRole addUserRole(UserRolesDto userRolesDto){
        UserRole userRole = convertUserRoleDtotoUserRole(userRolesDto);
        return userRoleRepository.save(userRole);
    }

    public UserRolesDto findById(Long id) throws UserNotFoundException {
        if(userRoleRepository.findById(id).isPresent()){
            UserRole userRole = userRoleRepository.findById(id).get();
            return convertUserRoleToUserRolesDto(userRole);
        }
        throw new UserNotFoundException("Invalid id or role type doesn't exist");
    }

    private UserRolesDto convertUserRoleToUserRolesDto(UserRole userRole) {
        UserRolesDto userRolesDto = new UserRolesDto();
        userRolesDto.setRoleID(userRole.getRoleID());
        userRolesDto.setRole(userRole.getRoleType());
        return userRolesDto;
    }

    private UserRole convertUserRoleDtotoUserRole(UserRolesDto userRolesDto) {
        UserRole userRole = new UserRole();
        userRole.setRoleID(userRolesDto.getRoleID());
        userRole.setRoleType(userRolesDto.getRole());
        userRole.setStartDate(LocalDate.now());
        return userRole;
    }
}
