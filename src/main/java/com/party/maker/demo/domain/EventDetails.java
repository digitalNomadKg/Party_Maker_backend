package com.party.maker.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "event_details")
public class EventDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EVENT_ID")
    private Long id;
    @Column(name = "EVENT_NAME")
    private String eventName;
    @Column(name = "EVENT_DATE")
    private LocalDate date;
    @Column(name = "BUDGET")
    private Integer budget;
    @Column(name = "ACTUAL_AMOUNT")
    private Integer actualAmount;
    @Column(name = "STATUS")
    @Enumerated(value = EnumType.STRING)
    private EventStatus eventStatus;
    @Column(name = "CREATED_DATE")
    private LocalDateTime createDate;
    @Column(name = "PAID_DATE")
    private LocalDateTime paidDate;
    @Column(name = "UPDATED_DATE")
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", nullable = true)
    private EventCategory category;

/*    private ClientPayment payments;
    private User user;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
