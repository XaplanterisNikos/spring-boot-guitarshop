package com.xaplanterisnikos.guitarshop.controller;

import com.xaplanterisnikos.guitarshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * REST controller for handling order-related requests.
 */
//@CrossOrigin("http://localhost:4200")
@RestController
public class OrdersController {

//    @GetMapping("/orders")
//    public ResponseEntity<List<String>> getMessages() {
//        return ResponseEntity.ok(Arrays.asList("Nikos","Anastasia"));
//    }

    private final OrderService orderService;

    /**
     * Constructs an OrdersController with the specified OrderService.
     *
     * @param orderService the service to manage orders
     */
    @Autowired
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }


    /**
     * Handles GET requests to retrieve customer names associated with orders.
     *
     * @return a ResponseEntity containing a list of customer names
     */
    @GetMapping("/orders")
    public ResponseEntity<List<String>> getMessages() {
        List<String> customerNames = orderService.getAllCustomerNames();
        return ResponseEntity.ok(customerNames);
    }
}
