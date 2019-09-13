package com.party.maker.demo.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserSessions {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long sessionID;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    private LocalDateTime logInTime;
    private LocalDateTime logOutTime;

    public Long getSessionID() {
        return sessionID;
    }

    public void setSessionID(Long sessionID) {
        this.sessionID = sessionID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLogInTime() {
        return logInTime;
    }

    public void setLogInTime(LocalDateTime logInTime) {
        this.logInTime = logInTime;
    }

    public LocalDateTime getLogOutTime() {
        return logOutTime;
    }

    public void setLogOutTime(LocalDateTime logOutTime) {
        this.logOutTime = logOutTime;
    }
}
