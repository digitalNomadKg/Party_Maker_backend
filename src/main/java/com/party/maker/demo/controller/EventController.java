package com.party.maker.demo.controller;

import com.party.maker.demo.domain.EventDetails;
import com.party.maker.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
    private final EventRepository eventRepository;

    @Autowired
    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @PostMapping(value = "/create")
    public EventDetails createEvent(@RequestBody EventDetails eventDetails) {
        return eventRepository.save(eventDetails);
    }

    @GetMapping(value = "/events")
    public ResponseEntity<List<EventDetails>> findAllEvents() {
        List<EventDetails> eventDetailsList = eventRepository.findAll();
        return new ResponseEntity<>(eventDetailsList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EventDetails> findById(@PathVariable Long id) {
        EventDetails details = eventRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id" + id));
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<EventDetails> update(@RequestBody EventDetails event, @PathVariable Long id) {
        if (eventRepository.findById(id).isPresent()) {
            eventRepository.save(event);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping(value = "/confirm/{id}")
    public ResponseEntity<EventDetails> confirm(@RequestBody EventDetails event, @PathVariable Long id) {
        if (eventRepository.findById(id).isPresent()) {
            eventRepository.save(event);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping(value = "/cancel/{id}")
    public ResponseEntity<EventDetails> cancel(@RequestBody EventDetails event, @PathVariable Long id) {
        if (eventRepository.findById(id).isPresent()) {
            eventRepository.save(event);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/delete/all")
    public ResponseEntity<? extends List<EventDetails>> deleteAllEvents() {
        List<EventDetails> eventList = eventRepository.findAll();
        return new ResponseEntity<>(eventList, HttpStatus.OK);
    }
}
