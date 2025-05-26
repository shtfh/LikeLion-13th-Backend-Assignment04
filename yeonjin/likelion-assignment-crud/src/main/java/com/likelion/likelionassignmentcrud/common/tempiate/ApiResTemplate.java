package com.likelion.likelionassignmentcrud.common.tempiate;

import com.likelion.likelionassignmentcrud.common.code.ErrorCode;
import com.likelion.likelionassignmentcrud.common.code.SuccessCode;
import lombok.Getter;

@Getter
public class ApiResTemplate<T> {

    private final int status;
    private final String message;
    private final T data;

    private ApiResTemplate(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    //성공 응답용
    public static <T> ApiResTemplate<T> successResponse(SuccessCode code, T data) {
        return new ApiResTemplate<>(code.getStatusCode(), code.getMessage(), data);
    }

    public static <T> ApiResTemplate<T> successWithNoContent(SuccessCode code) {
        return new ApiResTemplate<>(code.getStatusCode(), code.getMessage(), null);
    }

    //에러 응답용
    public static <T> ApiResTemplate<T> errorResponse(ErrorCode code, T data) {
        return new ApiResTemplate<>(code.getStatusCode(), code.getMessage(), data);
    }
}
