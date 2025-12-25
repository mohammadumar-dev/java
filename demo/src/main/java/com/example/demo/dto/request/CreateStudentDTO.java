package com.example.demo.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateStudentDTO {

    @NotBlank
    String name;

    @NotNull
    Integer age;

    @NotBlank
    @Email
    String email;

    @NotBlank
    String rollNumber;

    @NotBlank
    String course;

    @NotNull
    Integer year;

}
