package com.spcrey.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping
public class FfidController {
    @GetMapping
    public String ffid() {
        return "Hello World, FFID!";
    }
}
