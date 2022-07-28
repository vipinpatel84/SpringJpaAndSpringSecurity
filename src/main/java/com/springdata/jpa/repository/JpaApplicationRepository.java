package com.springdata.jpa.repository;

import com.springdata.jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaApplicationRepository extends JpaRepository<Student, Integer> {
}
