package com.example.demo.dto.resposne;

import com.example.demo.entity.Student;
import lombok.Value;

@Value
public class StudentResponseDto {
    Long id;
    String name;
    Integer age;
    String email;
    String rollNumber;
    String course;
    Integer year;
    String status;

    public static StudentResponseDto from(Student student) {
        return new StudentResponseDto(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getEmail(),
                student.getRollNumber(),
                student.getCourse(),
                student.getYear(),
                student.getStatus()
        );
    }
}
