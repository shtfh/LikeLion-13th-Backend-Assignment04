package com.likelion.likelionassignmentcrud.Student.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record StudentRequest(
        @NotBlank(message = "이름은 필수입니다.")
        @Size(min = 2, max = 10, message = "이름은 2자 이상 10자 이하로 입력해주세요.")
        String name,

        @NotBlank(message = "이메일은 필수입니다.")
        @Email(message = "유효한 이메일 형식을 입력해주세요.")
        String email,

        @NotBlank(message = "학과는 필수입니다.")
        @Size(max = 20, message = "학과는 20자 이내로 입력해주세요.")
        String major,

        @Min(value = 0, message = "나이는 0 이상이어야 합니다.")
        int age
) {
}
