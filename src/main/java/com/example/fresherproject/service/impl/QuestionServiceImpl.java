package com.example.fresherproject.service.impl;

import com.example.fresherproject.exception.ResourceNotFoundException;
import com.example.fresherproject.model.Questions;
import com.example.fresherproject.repository.QuestionRepository;
import com.example.fresherproject.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public void addQuestion(List<Questions> question) {
        questionRepository.saveAll(question);
    }

    @Override
    public List<Questions> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Questions> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> updateQuestion(Questions question, Long id) throws ResourceNotFoundException {
         Questions updateQuestion = questionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("question not found with id: " + id));
         updateQuestion.setQuestion(question.getQuestion());
         updateQuestion.setAnswer_a(question.getAnswer_a());
         updateQuestion.setAnswer_b(question.getAnswer_b()) ;
         updateQuestion.setAnswer_c(question.getAnswer_c());
         updateQuestion.setAnswer_d(question.getAnswer_d());
         updateQuestion.setCorrect_answer(question.getCorrect_answer());
         updateQuestion.setImg(question.getImg());
         questionRepository.save(updateQuestion);
         Map<String, Boolean> response = new HashMap<>();
         response.put("updated", Boolean.TRUE);
         return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteQuestion(Long id) throws ResourceNotFoundException {
        Questions questionNeedDel = questionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("question not found with id: " + id));
        questionRepository.delete(questionNeedDel);
        Map<String, Boolean> response = new HashMap<>();
        response.put("updated", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<Questions> getRandomQuestions() {
        List<Questions> questions = new ArrayList<>();
        long qty = questionRepository.count();
        for (int i = 0; i < 2; i++) {
            int index = (int) (Math.random() * qty);
            Page<Questions> questionPage = questionRepository.findAll(PageRequest.of(index, 1));
            Questions q = null;
            if (questionPage.hasContent()) {
                q = questionPage.getContent().get(0);
                questions.add(q);
            }
        }
        return questions;
    }

}
