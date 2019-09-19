package com.party.maker.demo.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "service_details")
public class ServiceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SERVICE_ID")
    private Long serviceID;
    @Column(name = "SERVICE_NAME")
    private String serviceName;
    @Column(name = "UOM")
    private String unitOfMeasurement;
    @Column(name = "UNIT_PRICE")
    private Long unitPrice;
    @Column(name = "CREATED_DATE")
    private LocalDateTime createDate;
    @Column(name = "UPDATED_DATE")
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "SERVICE_CATEGORY_ID")
    private ServiceCategory serviceCategory;

    public Long getServiceID() {
        return serviceID;
    }

    public void setServiceID(Long serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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

    public ServiceCategory getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(ServiceCategory serviceCategory) {
        this.serviceCategory = serviceCategory;
    }
}
