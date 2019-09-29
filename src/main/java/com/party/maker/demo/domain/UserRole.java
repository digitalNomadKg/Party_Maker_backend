package com.party.maker.demo.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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

   /* @OneToMany(targetEntity = User.class, mappedBy = "role")
    private List<User> userSet;

*/
/*
    public List<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = (List<User>) userSet;
    }
*/


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
