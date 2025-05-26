package com.likelion.likelionassignmentcrud.Assignment.api;

import com.likelion.likelionassignmentcrud.Assignment.api.dto.request.AssignmentRequest;
import com.likelion.likelionassignmentcrud.Assignment.api.dto.response.AssignmentResponse;
import com.likelion.likelionassignmentcrud.Assignment.application.AssignmentService;
import com.likelion.likelionassignmentcrud.common.code.SuccessCode;
import com.likelion.likelionassignmentcrud.common.tempiate.ApiResTemplate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;

    // 과제 등록
    @PostMapping("/save")
    public ApiResTemplate<String> createAssignment(@Valid @RequestBody AssignmentRequest request) {
        assignmentService.createAssignment(request);
        return ApiResTemplate.successWithNoContent(SuccessCode.ASSIGNMENT_CREATE_SUCCESS);
    }

    // 전체 과제 조회
    @GetMapping("/all")
    public ApiResTemplate<List<AssignmentResponse>> getAllAssignments() {
        List<AssignmentResponse> assignments = assignmentService.getAllAssignments();
        return ApiResTemplate.successResponse(SuccessCode.ASSIGNMENT_GET_SUCCESS, assignments);
    }

    // 특정 과제 조회
    @GetMapping("/{id}")
    public ApiResTemplate<AssignmentResponse> getAssignment(@PathVariable("id") Long id) {
        AssignmentResponse response = assignmentService.getAssignment(id);
        return ApiResTemplate.successResponse(SuccessCode.ASSIGNMENT_GET_SUCCESS, response);
    }

    // 과제 수정
    @PatchMapping("/{id}")
    public ApiResTemplate<String> updateAssignment(
            @PathVariable("id") Long id,
            @Valid @RequestBody AssignmentRequest request) {
        assignmentService.updateAssignment(id, request);
        return ApiResTemplate.successWithNoContent(SuccessCode.ASSIGNMENT_UPDATE_SUCCESS);
    }

    // 과제 삭제
    @DeleteMapping("/{id}")
    public ApiResTemplate<String> deleteAssignment(@PathVariable("id") Long id) {
        assignmentService.deleteAssignment(id);
        return ApiResTemplate.successWithNoContent(SuccessCode.ASSIGNMENT_DELETE_SUCCESS);
    }
}
