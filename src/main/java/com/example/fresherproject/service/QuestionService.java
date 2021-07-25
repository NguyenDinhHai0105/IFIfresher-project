package com.example.fresherproject.service;

import com.example.fresherproject.exception.ResourceNotFoundException;
import com.example.fresherproject.model.Questions;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public interface QuestionService {
    void addQuestion(List<Questions> question);
    List<Questions> getAllQuestions();
    Optional<Questions> getQuestionById(Long id);
    ResponseEntity<Map<String, Boolean>> updateQuestion (Questions questions, Long id) throws ResourceNotFoundException;
    ResponseEntity<Map<String, Boolean>> deleteQuestion (Long id) throws ResourceNotFoundException;
    List<Questions> getRandomQuestions();

}
