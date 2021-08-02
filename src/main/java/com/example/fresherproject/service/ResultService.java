package com.example.fresherproject.service;

import com.example.fresherproject.model.Result;
import com.example.fresherproject.model.Tests;
import org.springframework.stereotype.Service;

@Service
public interface ResultService {
    void saveResult(Result result);
}
