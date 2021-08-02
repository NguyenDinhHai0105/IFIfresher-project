package com.example.fresherproject.controller;

import com.example.fresherproject.exception.ResourceNotFoundException;
import com.example.fresherproject.model.Questions;
import com.example.fresherproject.model.Views;
import com.example.fresherproject.service.QuestionService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "*", maxAge = 3600)
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("")
    public List<Questions> getAllQuestions() { // lấy hết question, đã chạy
        return questionService.getAllQuestions();
    }

//    @GetMapping("/random")
//    public List<Questions> getRandomTest() { // lấy hết question, đã chạy
//        return questionService.getRandomQuestions();
//    }

    @GetMapping("/{id}")
    @JsonView(Views.Public.class)
    public Optional<Questions> getQuestionById(@PathVariable Long id) { // lấy ques bằng id, đã chạy
        return questionService.getQuestionById(id);
    }

    @GetMapping("/page")
    public Page<Questions> getQuestionsByPage(Pageable pageable) {
        return questionService.getQuestionsByPage(pageable);
    }

    @PostMapping("")
    public void addQuestion (@RequestBody List<Questions> questions){ // thêm ques // đã chạy
        questionService.addQuestion(questions);
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

    @GetMapping("/search")
    public List<Questions> searchQuestion(String input) {
        return questionService.searchQuestion(input);
    }
}
