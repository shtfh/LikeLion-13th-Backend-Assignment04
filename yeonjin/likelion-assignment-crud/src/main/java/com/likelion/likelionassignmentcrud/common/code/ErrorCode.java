package com.likelion.likelionassignmentcrud.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    STUDENT_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 학생이 없습니다.", "STUDENT_404"),
    ASSIGNMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 과제가 없습니다. AssignmentID =", "NOT_FOUND_404"),

    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다.", "BAD_REQUEST_400"),
    VALIDATION_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "유효성 검사에 실패 하였습니다", "BAD_REQUEST_400"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류 입니다.", "SERVER_500");

    private final HttpStatus httpStatus;
    private final String message;
    private final String code;

//    public int getHttpStatusCode() {
//        return httpStatus.value();
//    }

    public int getStatusCode() {
        return httpStatus.value();
    }

}
