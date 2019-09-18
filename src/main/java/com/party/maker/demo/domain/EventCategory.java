package com.party.maker.demo.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_category")
public class EventCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CATEGORY_ID")
    private Long id;
    @Column(name = "EVENT_NAME")
    private String eventName;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "STATUS")
    private EventStatus categoryStatus;
    @Column(name = "BUDGET")
    private Integer budget;
    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;
    @Column(name = "UPDATED_DATE")
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
