package com.party.maker.demo.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "order_details")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    private Long orderID;
    @Column(name = "QUANTITY")
    private Long quantity;
    @Column(name = "TOTAL_AMOUNT")
    private BigDecimal totalAmount;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "STATUS")
    private EventStatus status;
    @Column(name = "CREATED_BY")
    private LocalDateTime createDate;
    @Column(name = "UPDATED_BY")
    private LocalDateTime updateDate;
    @ManyToOne
    @JoinColumn(name = "EVENT_ID")
    private EventDetails eventDetails;
    @ManyToOne
    @JoinColumn(name = "SERVICE_ID")
    private ServiceDetails serviceDetails;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    public ServiceDetails getServiceDetails() {
        return serviceDetails;
    }

    public void setServiceDetails(ServiceDetails serviceDetails) {
        this.serviceDetails = serviceDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

