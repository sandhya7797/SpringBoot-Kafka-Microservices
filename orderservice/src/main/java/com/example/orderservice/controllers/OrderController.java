package com.example.orderservice.controllers;

import com.example.basecommons.dto.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/orders")
public class OrderController {

    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody Order order) {
        return ResponseEntity.status(HttpStatus.OK).body("Order successfully created");
    }
}
