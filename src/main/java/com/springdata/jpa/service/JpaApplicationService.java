package com.springdata.jpa.service;

import com.springdata.jpa.model.Student;
import com.springdata.jpa.repository.JpaApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaApplicationService {

    JpaApplicationRepository  jpaApplicationRepository;

    @Autowired
    public JpaApplicationService(JpaApplicationRepository jpaApplicationRepository) {
        this.jpaApplicationRepository = jpaApplicationRepository;
    }

    public List<Student> getAllStudents(){
        return null;
    }
}
