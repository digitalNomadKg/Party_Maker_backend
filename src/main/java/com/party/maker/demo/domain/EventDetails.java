package com.party.maker.demo.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class EventDetails {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long eventID;
    private String eventName;
    private LocalDate date;
    private Integer budget;
    private Integer actualAmount;
    @Enumerated(value = EnumType.STRING)
    private EventStatus eventStatus;
    private LocalDateTime createDate;
    private LocalDateTime paidDate;
    private LocalDateTime updateDate;
    @ManyToOne(fetch = FetchType.EAGER)
    private EventCategory category;
    @OneToMany(fetch = FetchType.LAZY)
    private List<ClientPayment> payments;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Long getEventID() {
        return eventID;
    }

    public void setEventID(Long eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(Integer actualAmount) {
        this.actualAmount = actualAmount;
    }

    public EventStatus getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(EventStatus eventStatus) {
        this.eventStatus = eventStatus;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(LocalDateTime paidDate) {
        this.paidDate = paidDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public EventCategory getCategory() {
        return category;
    }

    public void setCategory(EventCategory category) {
        this.category = category;
    }

    public List<ClientPayment> getPayments() {
        return payments;
    }

    public void setPayments(List<ClientPayment> payments) {
        this.payments = payments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
