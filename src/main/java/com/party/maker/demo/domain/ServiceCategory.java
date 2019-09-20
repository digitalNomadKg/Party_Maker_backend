
package com.party.maker.demo.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="service_category")
public class ServiceCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="SERVICE_CATEGORY_ID")
    private Long serviceCategoryID;
    @Column(name="SERVICE_CATEGORY_NAME")
    private String serviceName;
    @Enumerated(value = EnumType.STRING)
    @Column(name="STATUS")
    private EventStatus serviceStatus;
    @Column(name="CREATED_DATE")
    private LocalDateTime createDate;
    @Column(name="UPDATED_DATE")
    private LocalDateTime updateDate;

    public Long getServiceCategoryID() {
        return serviceCategoryID;
    }

    public void setServiceCategoryID(Long serviceCategoryID) {
        this.serviceCategoryID = serviceCategoryID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public EventStatus getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(EventStatus serviceStatus) {
        this.serviceStatus = serviceStatus;
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
}
