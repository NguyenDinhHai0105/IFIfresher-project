package com.example.fresherproject.service.impl;

import com.example.fresherproject.model.Tests;
import com.example.fresherproject.repository.TestRepository;
import com.example.fresherproject.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestRepository testRepository;

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
}
