package com.likelion.likelionassignmentcrud.Assignment.domain;

import com.likelion.likelionassignmentcrud.Student.domain.Student;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne
    @JoinColumn(name = "student_id") // 외래키
    private Student student;

    @Builder
    public Assignment(String title, String content, Student student) {
        this.title = title;
        this.content = content;
        this.student = student;

    }

    public void update(String title, String content, Student student) {
        this.title = title;
        this.content = content;
        this.student = student;
    }
}
