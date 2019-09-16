package com.party.maker.demo.dto;

import com.party.maker.demo.domain.UserRoleType;

public class UserRolesDto {
    private Long roleID;
    private UserRoleType role;

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public UserRoleType getRole() {
        return role;
    }

    public void setRole(UserRoleType role) {
        this.role = role;
    }
}
