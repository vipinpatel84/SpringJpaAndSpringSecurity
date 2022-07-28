package com.springdata.jpa.model;

public class Student {

    private Integer studentId;
    private String studentName;

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                '}';
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
