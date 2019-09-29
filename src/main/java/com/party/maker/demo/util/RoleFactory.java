package com.party.maker.demo.util;

import com.party.maker.demo.domain.UserRole;
import com.party.maker.demo.domain.UserRoleType;

public class RoleFactory {
    private UserRole userRole = new UserRole();

    UserRole assignRoleFactory(Long roleId) {

        if (1L == roleId) {
            userRole.setRoleID(roleId);
            userRole.setRoleType(UserRoleType.ADMIN);
        }
        if (roleId.equals(2L)) {
            userRole.setRoleID(roleId);
            userRole.setRoleType(UserRoleType.HOST);
        }
        if (roleId.equals(3L)) {
            userRole.setRoleID(roleId);
            userRole.setRoleType(UserRoleType.CLIENT);
        }
        return userRole;
    }

    public UserRoleType getRoleType(Long roleId) {

        if (roleId.equals(1L)) {
            return UserRoleType.ADMIN;
        } else if (roleId.equals(2L)) {
            return UserRoleType.HOST;
        } else {
            return UserRoleType.CLIENT;
        }
    }
}
