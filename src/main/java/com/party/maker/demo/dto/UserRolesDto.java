package com.party.maker.demo.dto;

import javax.persistence.Column;
import java.time.LocalDate;

public class UserRolesDto {
    private Long roleID;
    private String name;

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
