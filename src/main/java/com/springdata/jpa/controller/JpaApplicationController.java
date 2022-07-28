package com.springdata.jpa.controller;

import com.springdata.jpa.model.Student;
import com.springdata.jpa.service.JpaApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class JpaApplicationController {

    private JpaApplicationService jpaApplicationService;

    @Autowired
    public JpaApplicationController(JpaApplicationService jpaApplicationService) {
        this.jpaApplicationService = jpaApplicationService;
    }

    @GetMapping
    public List<Student> getAllStudentList(){
        List<Student> studentList= jpaApplicationService.getAllStudents();
        return studentList;
    }

    @GetMapping(path = "{studentId}")
    public Student getStudentById(@PathVariable Integer studentId){
        return new Student("Vipin Patel");
    }

    @DeleteMapping(path = "{student}")
    public void deleteStudentById(@PathVariable Integer studentId){
        System.out.println("StudentId "+studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable Integer studentId, @RequestBody Student student){
        System.out.println(" Student " + student);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
        System.out.println(
                "Student Object " + student
        );
    }
}
