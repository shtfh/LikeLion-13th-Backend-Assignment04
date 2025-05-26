package com.likelion.likelionassignmentcrud.common.exception;

import com.likelion.likelionassignmentcrud.common.code.ErrorCode;
import com.likelion.likelionassignmentcrud.common.exception.BusinessException;
import com.likelion.likelionassignmentcrud.common.tempiate.ApiResTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
@Component
@RequiredArgsConstructor
public class CustomExceptionAdvice {


    //500 서버 에러 처리
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ApiResTemplate<String> handleServerException(final Exception e) {
        log.error("Internal Server Error: {}", e.getMessage(), e);
        return ApiResTemplate.errorResponse(ErrorCode.INTERNAL_SERVER_ERROR, "예상치 못한 에러가 발생했습니다.");
    }


    //비지니스 예외 처리
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResTemplate<?>> handleCustomException(BusinessException e) {
        log.error("BusinessException: {}", e.getMessage(), e);
        ApiResTemplate<?> body = ApiResTemplate.errorResponse(e.getErrorCode(), e.getMessage());
        return ResponseEntity.status(e.getErrorCode().getHttpStatus())
                .body(body);
    }


    //유효성 검사 예외 처리
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResTemplate<String> handleValidationExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errorMap = new HashMap<>();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ApiResTemplate.errorResponse(ErrorCode.VALIDATION_EXCEPTION, convertMapToString(errorMap));
    }

    private String convertMapToString(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(" : ").append(entry.getValue()).append(", ");
        }
        if (sb.length() > 0) {
            sb.delete(sb.length() - 2, sb.length()); // 마지막 ", " 제거
        }
        return sb.toString();
    }
}
