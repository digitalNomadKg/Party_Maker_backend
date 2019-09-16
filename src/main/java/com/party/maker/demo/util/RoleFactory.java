package com.party.maker.demo.util;

import com.party.maker.demo.domain.User;
import com.party.maker.demo.domain.UserRole;
import com.party.maker.demo.domain.UserRoleType;

public class RoleFactory {
    private UserRole userRole = new UserRole();

    UserRole assignRoleFactory(Long roleId) {

        if (roleId == 1) {
            userRole.setRoleID(roleId);
            userRole.setRoleType(UserRoleType.ADMIN);
        }
        if (roleId == 2) {
            userRole.setRoleID(roleId);
            userRole.setRoleType(UserRoleType.HOST);
        }
        if (roleId == 3) {
            userRole.setRoleID(roleId);
            userRole.setRoleType(UserRoleType.CLIENT);
        }
        return null;
    }

    public UserRoleType getRoleType(Long roleId) {

        if (roleId == 1) {
            return UserRoleType.ADMIN;
        } else if (roleId == 2) {
            return UserRoleType.HOST;
        } else {
            return UserRoleType.CLIENT;
        }
    }
}
