package com.example.fresherproject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "questions")
@Data
public class Questions {

    @Id
    @GeneratedValue
    private Long id;

    private String question;

    private String answer_a;

    private String answer_b;

    private String answer_c;

    private String answer_d;

    private String correct_answer;

}
