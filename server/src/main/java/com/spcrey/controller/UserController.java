package com.spcrey.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spcrey.pojo.Result;

@RestController
@RequestMapping("/user")
public class UserController {
    @CrossOrigin(origins = "http://localhost:8081/")
    @GetMapping
    public Result<String> user() {
        return Result.success("This is user page!");
    }
}
