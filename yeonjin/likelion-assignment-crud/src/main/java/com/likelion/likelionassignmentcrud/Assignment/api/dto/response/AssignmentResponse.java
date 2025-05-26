package com.likelion.likelionassignmentcrud.Assignment.api.dto.response;

import com.likelion.likelionassignmentcrud.Assignment.domain.Assignment;
import lombok.Getter;

@Getter
public class AssignmentResponse {
    private Long id;
    private String title;
    private String content;
    private String studentId;

    public AssignmentResponse(Assignment assignment) {
        this.id = assignment.getId();
        this.title = assignment.getTitle();
        this.content = assignment.getContent();
        this.studentId = assignment.getStudent() != null
                ? assignment.getStudent().getName()
                : "미등록 학생"; // 또는 null
    }

}
