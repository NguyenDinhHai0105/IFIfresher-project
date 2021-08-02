package com.example.fresherproject.repository;

import com.example.fresherproject.model.Questions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Long> {
//    Page<Questions> findAll(Pageable pageable);
    List<Questions> findAllByQuestionIgnoreCaseLike(String input);
}
