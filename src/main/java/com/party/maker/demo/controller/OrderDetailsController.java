package com.party.maker.demo.controller;


import com.party.maker.demo.domain.OrderDetails;
import com.party.maker.demo.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderDetailsController {

    private final OrderDetailsRepository orderDetailsRepository;

    @Autowired
    public OrderDetailsController(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }


    @PostMapping(value = "/create")
    public OrderDetails createOrder(@RequestBody OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);

    }

    @GetMapping(value = "/orders")
    public ResponseEntity<Iterable<OrderDetails>> findAllEvents() {
        Iterable<OrderDetails> orderDetailsList=orderDetailsRepository.findAll();
        return new ResponseEntity<>(orderDetailsList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDetails> findById(@PathVariable Long id) {
        OrderDetails details = orderDetailsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id" + id));
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<OrderDetails> update(@RequestBody OrderDetails order, @PathVariable Long id) {
        if (orderDetailsRepository.findById(id).isPresent()) {
            orderDetailsRepository.save(order);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping(value = "/confirm/{id}")
    public ResponseEntity<OrderDetails> confirm(@RequestBody OrderDetails order, @PathVariable Long id) {
        if (orderDetailsRepository.findById(id).isPresent()) {
            orderDetailsRepository.save(order);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping(value = "/cancel/{id}")
    public ResponseEntity<OrderDetails> cancel(@RequestBody OrderDetails order, @PathVariable Long id) {
        if (orderDetailsRepository.findById(id).isPresent()) {
            orderDetailsRepository.save(order);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
