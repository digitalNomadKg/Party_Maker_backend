package com.party.maker.demo.service;

import com.party.maker.demo.domain.EventDetails;
import com.party.maker.demo.dto.EventDto;
import com.party.maker.demo.repository.EventRepository;
import com.party.maker.demo.util.EventDetailsAndEventDetailsDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventDetailsService {
    private final EventRepository eventRepository;
    private EventDetailsAndEventDetailsDtoConverter converter;

    @Autowired
    public EventDetailsService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public EventDetails save(EventDto eventDto) {
        EventDetails eventDetails = converter.convertEventDtoToEventDetails(eventDto);
        return eventRepository.save(eventDetails);
    }

    public List<EventDto> findAllEvents() {
        List<EventDetails> eventList = eventRepository.findAll();
        List<EventDto> eventDtos = new ArrayList<>();
        for (EventDetails eventDetails: eventList) {
            eventDtos.add(converter.convertEventDetailsToEventDto(eventDetails));
        }
        return eventDtos;
    }
}
