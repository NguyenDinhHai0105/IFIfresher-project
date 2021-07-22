package com.example.fresherproject.controller;

import com.example.fresherproject.exception.ResourceNotFoundException;
import com.example.fresherproject.model.Tests;
import com.example.fresherproject.model.Views;
import com.example.fresherproject.service.TestService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tests")
@CrossOrigin(origins = "*")

public class TestController {
    @Autowired
    TestService testService;

    @GetMapping("") // lấy tất cả bài test
    public List<Tests> getAllTests() {
        return testService.getAllTests();
    }

    @PostMapping("/add-tests") // thêm bài test
    public void addTests(@RequestBody Tests tests) {
        testService.addTest(tests);
    }

    @JsonView(Views.Public.class)
    @GetMapping("/{testId}") // lấy test by id
    public Optional<Tests> getTestById(@PathVariable Long testId) {
        return testService.getTestById(testId);
    }

    @DeleteMapping("/{id}") // xóa test by id
    public void deleteTest(@PathVariable Long id) throws ResourceNotFoundException {
        testService.deleteTest(id);
    }

    @PutMapping("/{id}")
    public void updateTest(@PathVariable Long id, @RequestBody Tests tests) throws ResourceNotFoundException {
        testService.updateTest(id, tests);
    }

    @GetMapping("/random") //
    public Optional<Tests> getRandomTest() {
        return testService.getRandomTest();
    }

}
