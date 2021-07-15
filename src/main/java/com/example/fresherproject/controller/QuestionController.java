package com.example.fresherproject.controller;

import com.example.fresherproject.exception.ResourceNotFoundException;
import com.example.fresherproject.model.Questions;
import com.example.fresherproject.model.Views;
import com.example.fresherproject.service.QuestionService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("")
    public List<Questions> getAllQuestions() { // lấy hết question, đã chạy
        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    @JsonView(Views.Public.class)
    public Optional<Questions> getQuestionById(@PathVariable Long id) { // lấy ques bằng id, đã chạy
        return questionService.getQuestionById(id);
    }

    @PostMapping("")
    public void addQuestion (@RequestBody Questions question){ // thêm ques // đã chạy
        questionService.addQuestion(question);
    }

    @PutMapping("/{id}")
    public void updateQuestion
            (@RequestBody Questions questions, @PathVariable Long id) throws ResourceNotFoundException {
        // update ques, đã chạy, được cho cả ques trong đề thi và ques không trong đề thi
        questionService.updateQuestion(questions, id);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) throws ResourceNotFoundException {
        questionService.deleteQuestion(id); // xóa ques, chỉ xóa đc quest chưa thuộc về đề thi nào
    }
}
