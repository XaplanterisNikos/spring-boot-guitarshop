package com.xaplanterisnikos.guitarshop.service;
import com.xaplanterisnikos.guitarshop.model.Order;
import com.xaplanterisnikos.guitarshop.dao.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<String> getAllCustomerNames() {
        return orderRepository.findAll().stream()
                .map(Order::getOrderTrackingNumber)
                .collect(Collectors.toList());
    }
}
