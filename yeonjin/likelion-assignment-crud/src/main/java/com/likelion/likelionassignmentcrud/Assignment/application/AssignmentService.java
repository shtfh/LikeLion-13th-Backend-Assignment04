package com.likelion.likelionassignmentcrud.Assignment.application;

import com.likelion.likelionassignmentcrud.Assignment.api.dto.request.AssignmentRequest;
import com.likelion.likelionassignmentcrud.Assignment.api.dto.response.AssignmentResponse;
import com.likelion.likelionassignmentcrud.Assignment.domain.Assignment;
import com.likelion.likelionassignmentcrud.Assignment.domain.repository.AssignmentRepository;
import com.likelion.likelionassignmentcrud.Student.domain.Student;
import com.likelion.likelionassignmentcrud.Student.domain.repository.StudentRepository;
import com.likelion.likelionassignmentcrud.common.code.ErrorCode;
import com.likelion.likelionassignmentcrud.common.exception.BusinessException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final StudentRepository studentRepository;

    public AssignmentResponse createAssignment(AssignmentRequest request) {
        Student student = studentRepository.findById(request.studentId())
                .orElseThrow(() -> new BusinessException(ErrorCode.STUDENT_NOT_FOUND, ErrorCode.STUDENT_NOT_FOUND.getMessage()));

        Assignment assignment = Assignment.builder()
                .title(request.title())
                .content(request.content())
                .student(student)
                .build();

        return new AssignmentResponse(assignmentRepository.save(assignment));
    }

    public List<AssignmentResponse> getAllAssignments() {
        return assignmentRepository.findAll().stream()
                .map(AssignmentResponse::new)
                .collect(Collectors.toList());
    }

    public AssignmentResponse getAssignment(Long id) {
        Assignment assignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.ASSIGNMENT_NOT_FOUND, ErrorCode.ASSIGNMENT_NOT_FOUND.getMessage()));
        return new AssignmentResponse(assignment);
    }

    public AssignmentResponse updateAssignment(Long id, AssignmentRequest request) {
        Assignment assignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.ASSIGNMENT_NOT_FOUND, ErrorCode.ASSIGNMENT_NOT_FOUND.getMessage()));

        Student student = studentRepository.findById(request.studentId())
                .orElseThrow(() -> new BusinessException(ErrorCode.STUDENT_NOT_FOUND, ErrorCode.STUDENT_NOT_FOUND.getMessage()));

        assignment.update(request.title(), request.content(), student);
        return new AssignmentResponse(assignment);
    }

    public void deleteAssignment(Long id) {
        Assignment assignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.ASSIGNMENT_NOT_FOUND, ErrorCode.ASSIGNMENT_NOT_FOUND.getMessage()));
        assignmentRepository.delete(assignment);
    }
}
