package com.example.fresherproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long user_id;

    private Long test_id;

    private Long question_id;

    private Long core;

    private String user_answer;

//    @ManyToOne
//    @JoinColumn(name = "id", insertable = false, updatable = false)
//    private User user;

}
