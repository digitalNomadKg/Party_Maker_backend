package com.party.maker.demo.controller;

import com.party.maker.demo.domain.ServiceDetails;
import com.party.maker.demo.repository.ServiceDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class ServiceDetailsController {
    private final ServiceDetailsRepository serviceDetailsRepository;

    @Autowired
    public ServiceDetailsController(ServiceDetailsRepository serviceDetailsRepository) {
        this.serviceDetailsRepository = serviceDetailsRepository;
    }

    @PostMapping("/add")
    public ServiceDetails create(@RequestBody ServiceDetails serviceDetails){
        return serviceDetailsRepository.save(serviceDetails);
    }

    @GetMapping("/services")
    public ResponseEntity<Iterable<ServiceDetails>> getAllServiceDetails(){
        Iterable<ServiceDetails> serviceDetails = serviceDetailsRepository.findAll();
        return new ResponseEntity<>(serviceDetails, HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<ServiceDetails> update(@RequestBody ServiceDetails serviceDetails, @PathVariable Long id){
        if(serviceDetailsRepository.findById(id).isPresent()){
            serviceDetailsRepository.save(serviceDetails);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ServiceDetails> delete(@PathVariable Long id, ServiceDetails serviceDetails){
        if(serviceDetailsRepository.findById(id).isPresent()){
            serviceDetailsRepository.delete(serviceDetails);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




}
