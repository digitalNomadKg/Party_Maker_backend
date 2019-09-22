package com.party.maker.demo.util;

import com.party.maker.demo.domain.EventDetails;
import com.party.maker.demo.dto.EventDto;

public class EventDetailsAndEventDetailsDtoConverter {
    public EventDetails convertEventDtoToEventDetails(EventDto eventDto){
        EventDetails eventDetails = new EventDetails();
        eventDetails.setActualAmount(eventDto.getActualAmount());
        eventDetails.setBudget(eventDto.getBudget());
        eventDetails.setCategory(eventDto.getCategory());
        eventDetails.setCreateDate(eventDto.getCreateDate());
        eventDetails.setDate(eventDto.getDate());
        eventDetails.setEventName(eventDto.getEventName());
        eventDetails.setEventStatus(eventDto.getEventStatus());
        eventDetails.setId(eventDto.getId());
        eventDetails.setPaidDate(eventDto.getPaidDate());
        eventDetails.setUpdateDate(eventDto.getUpdateDate());
        eventDetails.setUser(eventDto.getUser());
        return eventDetails;
    }

    public EventDto convertEventDetailsToEventDto(EventDetails eventDetails){
        EventDto eventDto = new EventDto();
        eventDto.setActualAmount(eventDetails.getActualAmount());
        eventDto.setBudget(eventDetails.getBudget());
        eventDto.setCategory(eventDetails.getCategory());
        eventDto.setCreateDate(eventDetails.getCreateDate());
        eventDto.setDate(eventDetails.getDate());
        eventDto.setEventName(eventDetails.getEventName());
        eventDto.setEventStatus(eventDetails.getEventStatus());
        eventDto.setId(eventDetails.getId());
        eventDto.setPaidDate(eventDetails.getPaidDate());
        eventDto.setUpdateDate(eventDetails.getUpdateDate());
        eventDto.setUser(eventDetails.getUser());
        return eventDto;
    }
}
