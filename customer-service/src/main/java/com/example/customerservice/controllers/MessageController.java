package com.example.customerservice.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //important pour prendre en compte la maj avec actuator
public class MessageController {

    @Value("${app.message:Default message}")
    private String message;

    @GetMapping("/message")
    public String getMessage() {
        return message;
    }
}
