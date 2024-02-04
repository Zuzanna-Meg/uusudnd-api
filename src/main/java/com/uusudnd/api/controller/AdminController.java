package com.uusudnd.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/status")
public class AdminController {

    @GetMapping
    public ResponseEntity<String> checkStatus() {
        return new ResponseEntity<>("Status: online", HttpStatus.OK);
    }
}
