package com.party.maker.demo.domain;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "event_category")
public class EventCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    @Column(name = "EVENT_NAME")
    private String eventName;


    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "category")
    private Set<EventDetails> eventDetails = new HashSet<>();
    //private List<EventDetails> eventDetailsList;
   /* @Enumerated(value = EnumType.STRING)
    private EventStatus categoryStatus;
    private Integer budget;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;*/

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Set<EventDetails> getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(Set<EventDetails> eventDetails) {
        this.eventDetails = eventDetails;
    }
}
