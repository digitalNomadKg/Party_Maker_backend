package com.party.maker.demo.controller;

import com.party.maker.demo.domain.EventCategory;
import com.party.maker.demo.repository.EventCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class EventCategoryController {
    private final EventCategoryRepository categoryRepository;

    @Autowired
    public EventCategoryController(EventCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping("/add")
    public EventCategory create(@RequestBody EventCategory category){
        return categoryRepository.save(category);
    }

    @GetMapping("/categories")
    public ResponseEntity<Iterable<EventCategory>> getAllCategories(){
        Iterable<EventCategory> categories = categoryRepository.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<EventCategory> update(@RequestBody EventCategory category, @PathVariable Long id){
        if(categoryRepository.findById(id).isPresent()){
            categoryRepository.save(category);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EventCategory> delete(@PathVariable Long id, EventCategory category){
        if(categoryRepository.findById(id).isPresent()){
        categoryRepository.delete(category);
        return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
