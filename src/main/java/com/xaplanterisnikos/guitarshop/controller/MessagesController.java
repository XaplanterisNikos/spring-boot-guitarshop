package com.xaplanterisnikos.guitarshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

//@CrossOrigin("http://localhost:4200")
@RestController
public class MessagesController {

    @GetMapping("/messages")
    public ResponseEntity<List<String>> getMessages() {
        return ResponseEntity.ok(Arrays.asList("Nikos","Anastasia"));
    }
}
