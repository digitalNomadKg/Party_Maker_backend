package com.party.maker.demo.controller;

import com.party.maker.demo.domain.EventDetails;
import com.party.maker.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {
    private final EventRepository eventRepository;

    @Autowired
    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @PostMapping(value = "create")
    public EventDetails createEvent(@RequestBody EventDetails eventDetails){
        return eventRepository.save(eventDetails);
    }
}
