package com.example.fresherproject.controller;

import com.example.fresherproject.model.Tests;
import com.example.fresherproject.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "*")
public class PublicAPI {
    @Autowired
    TestService testService;

    @GetMapping("") // lấy tất cả bài test
    public List<Tests> getAllTests() {
        return testService.getAllTests();
    }
}
