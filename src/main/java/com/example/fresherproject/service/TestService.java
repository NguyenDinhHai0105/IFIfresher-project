package com.example.fresherproject.service;

import com.example.fresherproject.model.Tests;
import org.aspectj.weaver.ast.Test;

import java.util.List;
import java.util.Optional;

public interface TestService {
    void addTest(Tests tests);
    List<Tests> getAllTests();
    Optional<Tests> getTestById(Long id);
}
