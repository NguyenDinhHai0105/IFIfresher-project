package com.example.fresherproject.service;

import com.example.fresherproject.exception.ResourceNotFoundException;
import com.example.fresherproject.model.Questions;
import com.example.fresherproject.model.Tests;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface TestService {
    void addTest(Tests tests);
    List<Tests> getAllTests();
    Optional<Tests> getTestById(Long id);
    ResponseEntity<Map<String, Boolean>> deleteTest(Long id) throws ResourceNotFoundException;
    ResponseEntity<Map<String, Boolean>> updateTest(Long id, Tests tests) throws ResourceNotFoundException;
    Optional<Tests> getRandomTest();
}
