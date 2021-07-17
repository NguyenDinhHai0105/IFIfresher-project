package com.example.fresherproject.service.impl;

import com.example.fresherproject.exception.ResourceNotFoundException;
import com.example.fresherproject.model.Questions;
import com.example.fresherproject.repository.QuestionRepository;
import com.example.fresherproject.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public void addQuestion(Questions question) {
        questionRepository.save(question);
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
}
