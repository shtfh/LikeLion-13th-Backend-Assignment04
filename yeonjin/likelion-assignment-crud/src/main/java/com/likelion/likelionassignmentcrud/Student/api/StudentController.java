package com.likelion.likelionassignmentcrud.Student.api;

import com.likelion.likelionassignmentcrud.Student.api.dto.request.StudentRequest;
import com.likelion.likelionassignmentcrud.Student.api.dto.response.StudentResponse;
import com.likelion.likelionassignmentcrud.Student.application.StudentService;
import com.likelion.likelionassignmentcrud.common.code.SuccessCode;
import com.likelion.likelionassignmentcrud.common.tempiate.ApiResTemplate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    //학생 등록
    @PostMapping("/save")
    public ApiResTemplate<StudentResponse> createStudent(@Valid @RequestBody StudentRequest request) {
        StudentResponse response = studentService.createStudent(request);
        return ApiResTemplate.successResponse(SuccessCode.STUDENT_CREATE_SUCCESS, response);
    }

    // 전체 학생 조회
    @GetMapping
    public ApiResTemplate<List<StudentResponse>> getAllStudents() {
        List<StudentResponse> responseList = studentService.getAllStudents();
        return ApiResTemplate.successResponse(SuccessCode.STUDENT_GET_SUCCESS, responseList);
    }

    //특정 학생 조회
    @GetMapping("/{studentId}")
    public ApiResTemplate<StudentResponse> getStudent(@PathVariable("studentId") Long id) {
        StudentResponse response = studentService.getStudent(id);
        return ApiResTemplate.successResponse(SuccessCode.STUDENT_GET_SUCCESS, response);
    }

    //학생 정보 수정
    @PatchMapping("/{studentId}")
    public ApiResTemplate<StudentResponse> updateStudent(
            @PathVariable("studentId") Long id,
            @Valid @RequestBody StudentRequest request) {
        StudentResponse response = studentService.updateStudent(id, request);
        return ApiResTemplate.successResponse(SuccessCode.STUDENT_UPDATE_SUCCESS, response);
    }

    //학생 삭제
    @DeleteMapping("/{studentId}")
    public ApiResTemplate<String> deleteStudent(@PathVariable("studentId") Long id) {
        studentService.deleteStudent(id);
        return ApiResTemplate.successResponse(SuccessCode.STUDENT_DELETE_SUCCESS, "학생 삭제 완료");
    }
}
