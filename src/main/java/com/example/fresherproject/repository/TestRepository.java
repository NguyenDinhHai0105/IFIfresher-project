package com.example.fresherproject.repository;

import com.example.fresherproject.model.Tests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Tests, Long> {
}
