package com.example.fresherproject.model;

import lombok.Data;
import sun.util.calendar.LocalGregorianCalendar;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "tests")
@Data

public class Tests {

    @Id
    @GeneratedValue
    private Long id;

    private String test_name;

    private Integer test_time;

    private Integer number_of_questions;

    private Date creat_at;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "tests_questions",
                        joinColumns = @JoinColumn(name = "test_id"),
                        inverseJoinColumns = @JoinColumn(name = "question_id"))
    private List<Questions> questions;
}
