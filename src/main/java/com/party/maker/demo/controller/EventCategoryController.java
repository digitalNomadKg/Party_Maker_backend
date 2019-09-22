package com.party.maker.demo.controller;

import com.party.maker.demo.domain.EventCategory;
import com.party.maker.demo.dto.EventCategoryDto;
import com.party.maker.demo.exceptions.CategoryNotFoundException;
import com.party.maker.demo.service.EventCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class EventCategoryController {

    private final EventCategoryService eventCategoryService;

    @Autowired
    public EventCategoryController(EventCategoryService eventCategoryService) {
        this.eventCategoryService = eventCategoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity<Iterable<EventCategory>> getAllCategories() {
        return new ResponseEntity(eventCategoryService.getAllCategories(), HttpStatus.OK);
    }


    @PostMapping("/add")
    public EventCategory create(@RequestBody EventCategoryDto categoryDto) {
        return eventCategoryService.save(categoryDto);
    }


    @PatchMapping("/update/{id}")
    public ResponseEntity<EventCategory> update(@RequestBody EventCategoryDto categoryDto, @PathVariable Long id) {
        if (eventCategoryService.findById(id) != null) {
            eventCategoryService.save(categoryDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (eventCategoryService.findById(id) != null) {
            eventCategoryService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
