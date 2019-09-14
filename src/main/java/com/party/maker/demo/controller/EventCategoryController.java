package com.party.maker.demo.controller;

import com.party.maker.demo.domain.EventCategory;
import com.party.maker.demo.repository.EventCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category/event")
public class EventCategoryController {
    private final EventCategoryRepository categoryRepository;

    @Autowired
    public EventCategoryController(EventCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping("/create")
    public EventCategory createCategory(@RequestBody EventCategory category){
        return categoryRepository.save(category);
    }
}
