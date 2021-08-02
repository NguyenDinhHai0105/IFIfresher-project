package com.example.fresherproject.service.impl;

import com.example.fresherproject.exception.ResourceNotFoundException;
import com.example.fresherproject.model.Questions;
import com.example.fresherproject.model.Tests;
import com.example.fresherproject.repository.QuestionRepository;
import com.example.fresherproject.repository.TestRepository;
import com.example.fresherproject.service.QuestionService;
import com.example.fresherproject.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestRepository testRepository;

    @Autowired
    QuestionService questionService;

    @Override
    public void addTest(Tests tests) {
        testRepository.save(tests);
    }

    @Override
    public List<Tests> getAllTests() {
        return testRepository.findAll();
    }

    @Override
    public Optional<Tests> getTestById(Long id) {
        return testRepository.findById(id);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteTest(Long id) throws ResourceNotFoundException {
        Tests tests = testRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("test not found with id: " + id));
        testRepository.delete(tests);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> updateTest(Long id, Tests testsDetails) throws ResourceNotFoundException {
        Tests tests = testRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("id not found: " + id));
        tests.setTest_name(testsDetails.getTest_name());
        tests.setTest_time(testsDetails.getTest_time());
        tests.setNumber_of_questions(testsDetails.getNumber_of_questions());
        tests.setCreat_at(testsDetails.getCreat_at());
        tests.setQuestions(testsDetails.getQuestions());
        testRepository.save(tests);
        Map<String, Boolean> response = new HashMap<>();
        response.put("updated", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @Override
    public Optional<Tests> getRandomTest() {
        List<Questions> questions = questionService.getRandomQuestions();
        Optional<Tests> test = Optional.of(new Tests(20, questions));
        return test;
    }


}
