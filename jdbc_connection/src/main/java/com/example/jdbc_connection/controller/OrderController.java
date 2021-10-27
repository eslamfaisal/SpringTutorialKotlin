package com.example.jdbc_connection.controller;

import com.example.jdbc_connection.entity.Order;
import com.example.jdbc_connection.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllLocations() {
        List<Order> list = orderService.retrieveOrders();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<String> saveOrder(@RequestBody Order order) {
        try {
            System.out.println(order);
            orderService.saveOrder(order);
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
