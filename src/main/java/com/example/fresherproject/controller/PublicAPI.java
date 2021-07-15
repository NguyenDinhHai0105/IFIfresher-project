package com.example.fresherproject.controller;

import com.example.fresherproject.model.Tests;
import com.example.fresherproject.model.Views;
import com.example.fresherproject.service.TestService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @JsonView(Views.Public.class)
    @GetMapping("/{id}") // lấy tất cả bài test
    public Optional<Tests> getTestById(@PathVariable Long id) {
        return testService.getTestById(id);
    }
}
