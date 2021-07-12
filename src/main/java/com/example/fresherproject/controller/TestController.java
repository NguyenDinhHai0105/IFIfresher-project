package com.example.fresherproject.controller;

import com.example.fresherproject.model.Tests;
import com.example.fresherproject.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tests")
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping("/get-all-tests")
    public List<Tests> getAllTests() {
        return testService.getAllTests();
    }

    @PostMapping("/add-tests")
    public void addTests(@RequestBody Tests tests) {
        testService.addTest(tests);
    }

    @GetMapping("/get-test/{testId}")
    public Optional<Tests> getTestById(@PathVariable Long testId) {
        return testService.getTestById(testId);
    }

}
