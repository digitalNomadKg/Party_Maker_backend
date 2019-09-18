package com.party.maker.demo.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user_roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Long roleID;
    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE_NAME")
    private UserRoleType roleType;
    @Column(name = "START_DATE")
    private LocalDate startDate;

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public UserRoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(UserRoleType roleType) {
        this.roleType = roleType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
