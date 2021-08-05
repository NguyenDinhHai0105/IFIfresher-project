package com.example.fresherproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "questions")
@Data
@AllArgsConstructor
@JsonView(Views.Public.class)
public class Questions {

    @Id
    @GeneratedValue
    private Long id;

    private String question;

    private String answer_a;

    private String answer_b;

    private String answer_c;

    private String answer_d;

    //@JsonView(Views.Private.class)
    private String correct_answer;

    private String img;

    @ManyToMany(mappedBy = "questions")
    @JsonIgnore
    private List<Tests> tests;

    public Questions() {

    }

    public Questions(String question, String answer_a, String answer_b, String answer_c, String answer_d, String correct_answer) {
        this.question = question;
        this.answer_a = answer_a;
        this.answer_b = answer_b;
        this.answer_c = answer_c;
        this.answer_d = answer_d;
        this.correct_answer = correct_answer;
    }

    public Questions(String question, String answer_a, String answer_b, String answer_c, String answer_d, String correct_answer, String img) {
        this.question = question;
        this.answer_a = answer_a;
        this.answer_b = answer_b;
        this.answer_c = answer_c;
        this.answer_d = answer_d;
        this.correct_answer = correct_answer;
        this.img = img;
    }

}
