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
        return jpaApplicationRepository.findAll();
    }

    public Student getStudentById(Integer studentId){
        boolean exist =jpaApplicationRepository.existsById(studentId);
    if (!exist){
        throw new IllegalArgumentException("Student does not exist" );
    }
        return jpaApplicationRepository.findById(studentId).get();
    }

    public void deletStudentById(Integer studentId){
        boolean exist =jpaApplicationRepository.existsById(studentId);
        if (!exist){
            throw new IllegalArgumentException("Student does not exist" );
        }
        jpaApplicationRepository.deleteById(studentId);
    }

    public void addStudent(Student student){
        if(student.getStudentName().isEmpty() || null==student.getStudentName()){
            throw new IllegalArgumentException("Student does not exist" );
        }
        jpaApplicationRepository.save(student);
    }

    public void updateStudent(Integer studentId, Student student){
        boolean exist =jpaApplicationRepository.existsById(studentId);
        if (!exist){
            throw new IllegalArgumentException("Student does not exist" );
        }
    }
}
