package com.party.maker.demo.controller;

import com.party.maker.demo.domain.EventCategory;
import com.party.maker.demo.domain.ServiceCategory;
import com.party.maker.demo.repository.ServiceCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/servicecategory")
public class ServiceCategoryController {

    private final ServiceCategoryRepository serviceCategoryRepository;


    @Autowired
    public ServiceCategoryController(ServiceCategoryRepository serviceCategoryRepository) {
        this.serviceCategoryRepository = serviceCategoryRepository;
    }

    @PostMapping("/add")
    public ServiceCategory create(@RequestBody ServiceCategory category) {
        return serviceCategoryRepository.save(category);
    }

    @GetMapping("/categories")
    public ResponseEntity<Iterable<ServiceCategory>> getAllCategories() {
        Iterable<ServiceCategory> categories = serviceCategoryRepository.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<ServiceCategory> update(@RequestBody ServiceCategory category, @PathVariable Long id) {
        if (serviceCategoryRepository.findById(id).isPresent()) {
            serviceCategoryRepository.save(category);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ServiceCategory> delete(@PathVariable Long id, ServiceCategory category) {
        if (serviceCategoryRepository.findById(id).isPresent()) {
            serviceCategoryRepository.delete(category);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
