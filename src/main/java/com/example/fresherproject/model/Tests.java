package com.example.fresherproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "tests")
@Data

@JsonView(Views.Public.class)
public class Tests {

    @Id
    @GeneratedValue
    private Long id;

    private String test_name;

    private Integer test_time;

    private Integer number_of_questions;

    private LocalDate creat_at = java.time.LocalDate.now();

    @ManyToMany(mappedBy = "tests")
    private Set<User> users;

    @ManyToMany(cascade = {CascadeType.DETACH,  CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinTable(name = "tests_questions",
                        joinColumns = @JoinColumn(name = "test_id"),
                        inverseJoinColumns = @JoinColumn(name = "question_id"))
    private List<Questions> questions;

    public Tests() {

    }

    public Tests(String test_name, Integer test_time, Integer number_of_questions) {
        this.test_name = test_name;
        this.test_time = test_time;
        this.number_of_questions = number_of_questions;
    }

    public Tests(Integer test_time, List<Questions> questions) {
        this.test_time = test_time;
        this.questions = questions;
    }
}
