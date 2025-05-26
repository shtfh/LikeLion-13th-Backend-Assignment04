package com.likelion.likelionassignmentcrud.Student.api.dto.response;

import com.likelion.likelionassignmentcrud.Student.domain.Student;
import lombok.Getter;

@Getter
public class StudentResponse {
    private Long id;
    private String name;
    private String major;
    private String email;
    private int age;

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.major = student.getMajor();
        this.email = student.getEmail();
        this.age = student.getAge();
    }
}
