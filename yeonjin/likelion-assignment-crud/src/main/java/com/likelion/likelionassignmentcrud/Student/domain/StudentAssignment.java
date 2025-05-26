package com.likelion.likelionassignmentcrud.Student.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class StudentAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private LocalDate submittedAt;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public StudentAssignment(String title, String content, LocalDate submittedAt, Student student) {
        this.title = title;
        this.content = content;
        this.submittedAt = submittedAt;
        this.student = student;
    }
}
