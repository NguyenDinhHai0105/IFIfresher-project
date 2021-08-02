package com.example.fresherproject.service.impl;

import com.example.fresherproject.model.Result;
import com.example.fresherproject.model.Tests;
import com.example.fresherproject.repository.ResultRepository;
import com.example.fresherproject.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    ResultRepository resultRepository;

    @Override
    public void saveResult(Result result) {

    }
}
