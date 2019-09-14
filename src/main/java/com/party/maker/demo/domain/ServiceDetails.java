/*
package com.party.maker.demo.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ServiceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long serviceID;
    @OneToMany(fetch = FetchType.EAGER)
    private ServiceCategory service;
    private String unitOfMeasurement;
    private Long unitPrice;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Long getServiceID() {
        return serviceID;
    }

    public void setServiceID(Long serviceID) {
        this.serviceID = serviceID;
    }

    public ServiceCategory getService() {
        return service;
    }

    public void setService(ServiceCategory service) {
        this.service = service;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
*/
