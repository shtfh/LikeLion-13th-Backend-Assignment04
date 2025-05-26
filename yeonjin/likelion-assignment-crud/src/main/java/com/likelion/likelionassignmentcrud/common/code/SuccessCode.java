package com.likelion.likelionassignmentcrud.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessCode {

    // 학생 관련 성공 코드
    STUDENT_CREATE_SUCCESS(HttpStatus.CREATED, "학생 생성에 성공했습니다."),
    STUDENT_UPDATE_SUCCESS(HttpStatus.OK, "학생 수정에 성공했습니다."),
    STUDENT_DELETE_SUCCESS(HttpStatus.OK, "학생 삭제에 성공했습니다."),
    STUDENT_GET_SUCCESS(HttpStatus.OK, "학생 조회에 성공했습니다."),

    // 과제 관련 성공 코드
    ASSIGNMENT_CREATE_SUCCESS(HttpStatus.CREATED, "과제 생성에 성공했습니다."),
    ASSIGNMENT_UPDATE_SUCCESS(HttpStatus.OK, "과제 수정에 성공했습니다."),
    ASSIGNMENT_DELETE_SUCCESS(HttpStatus.OK, "과제 삭제에 성공했습니다."),
    ASSIGNMENT_GET_SUCCESS(HttpStatus.OK, "과제 조회에 성공했습니다.");

    private final HttpStatus httpStatus;
    private final String message;

    // ApiResTemplate에서 사용할 HTTP 상태 코드 정수 반환 메서드
    public int getStatusCode() {
        return httpStatus.value();  // 예: HttpStatus.OK → 200
    }
}
