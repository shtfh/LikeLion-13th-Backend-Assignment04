package com.likelion.likelionassignmentcrud.Student.application;

import com.likelion.likelionassignmentcrud.Student.api.dto.request.StudentRequest;
import com.likelion.likelionassignmentcrud.Student.api.dto.response.StudentResponse;
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
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentResponse createStudent(StudentRequest request) {
        Student student = Student.builder()
                .name(request.name())
                .major(request.major())
                .email(request.email())
                .age(request.age())
                .build();

        return new StudentResponse(studentRepository.save(student));
    }


    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(StudentResponse::new)
                .collect(Collectors.toList());
    }

    public StudentResponse getStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.STUDENT_NOT_FOUND));
        return new StudentResponse(student);
    }

    public StudentResponse updateStudent(Long id, StudentRequest request) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.STUDENT_NOT_FOUND));
        student.update(request.name(), request.email(), request.major(), request.age());
        return new StudentResponse(student);
    }

    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.STUDENT_NOT_FOUND));
        studentRepository.delete(student);
    }
}
