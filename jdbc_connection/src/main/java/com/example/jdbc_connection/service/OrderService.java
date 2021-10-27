package com.example.jdbc_connection.service;

import com.example.jdbc_connection.entity.Order;
import com.example.jdbc_connection.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> retrieveOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }


}
