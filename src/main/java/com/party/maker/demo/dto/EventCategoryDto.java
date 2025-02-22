package com.party.maker.demo.dto;

import com.party.maker.demo.domain.EventStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

public class EventCategoryDto {
    private Long id;
    private String eventName;
    private EventStatus categoryStatus;
    private Integer budget;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

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

    public EventStatus getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(EventStatus categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}



