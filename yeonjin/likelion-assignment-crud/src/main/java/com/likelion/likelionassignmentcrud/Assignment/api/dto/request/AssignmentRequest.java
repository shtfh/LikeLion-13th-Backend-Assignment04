package com.likelion.likelionassignmentcrud.Assignment.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AssignmentRequest(

        @NotBlank(message = "제목은 필수입니다.")
        @Size(max = 50, message = "제목은 50자 이내로 입력해주세요.")
        String title,

        @NotBlank(message = "내용은 필수입니다.")
        String content,

        @NotNull(message = "학생 ID는 필수입니다.")
        Long studentId

) {}
