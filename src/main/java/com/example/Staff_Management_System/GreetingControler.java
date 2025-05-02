package com.example.Staff_Management_System;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController

public class GreetingControler {
    @GetMapping("/greet")
    public String greeting(){
        return "Welcome I am Greeting You";
    }

    @GetMapping("/{name}")
    public String spec_greeting(@PathVariable String name){
        return "Welcome i am greeting you "+name+" for islamic greeting";
    }

    @GetMapping("/success")
    public ResponseEntity<String> getok(){
        String result = "The work is done and its OK";
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/notfound")
    public ResponseEntity<Map<String, String>> Not_Found(){
        Map<String,String> errordetail = new HashMap<>();
        errordetail.put("Error","404 Happen");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errordetail);
    }
    @PostMapping("/create")
    public ResponseEntity<String> createresource() {
        HttpHeaders headers = new HttpHeaders();
        String naming = "Created";
        headers.add("create", "resource " +naming);
        String body = "Resource has been "+naming ;
        return new ResponseEntity<>(body, headers, HttpStatus.CREATED);
    }
}
