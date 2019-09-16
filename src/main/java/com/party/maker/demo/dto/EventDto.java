package com.party.maker.demo.dto;

import com.party.maker.demo.domain.EventCategory;
import com.party.maker.demo.domain.EventStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EventDto {
    private Long id;
    private String eventName;
    private LocalDate date;
    private Integer budget;
    private Integer actualAmount;
    private EventStatus eventStatus;
    private LocalDateTime createDate;
    private LocalDateTime paidDate;
    private LocalDateTime updateDate;
    private EventCategory category;

/*
    public EventDto() {
    }

    public EventDto(String eventName, LocalDate date, Integer budget, Integer actualAmount, EventStatus eventStatus,
                    LocalDateTime createDate, LocalDateTime paidDate, LocalDateTime updateDate, EventCategory category) {
        this.eventName = eventName;
        this.date = date;
        this.budget = budget;
        this.actualAmount = actualAmount;
        this.eventStatus = eventStatus;
        this.createDate = createDate;
        this.paidDate = paidDate;
        this.updateDate = updateDate;
        this.category = category;
    }
*/

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
