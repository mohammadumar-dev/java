package com.example.demo.controller;

import com.example.demo.dto.request.CreateStudentDTO;
import com.example.demo.dto.resposne.StudentResponseDto;
import com.example.demo.service.StudentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students/")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping(value = "create")
    public ResponseEntity<StudentResponseDto> create(@Valid @RequestBody CreateStudentDTO dto) {
        StudentResponseDto response = studentService.createStudent(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(value = "getby/{course}/{status}")
    public ResponseEntity<List<StudentResponseDto>> getListByCourseAndStatus(
            @NotBlank @PathVariable String course, @NotBlank @PathVariable String status) {
        List<StudentResponseDto> responseDtoList = studentService.getListByCourseAndStatus(course, status);
        return ResponseEntity.status(HttpStatus.OK).body(responseDtoList);
    }

    @GetMapping(value = "getby/{year}")
    public ResponseEntity<List<StudentResponseDto>> getListByYear(@PathVariable Integer year) {
        List<StudentResponseDto> responseDtoList = studentService.getListByYear(year);
        return ResponseEntity.status(HttpStatus.OK).body(responseDtoList);
    }

    @GetMapping(value = "getby/{name}/{course}")
    public ResponseEntity<List<StudentResponseDto>> getListByNameAndCourse(
            @PathVariable String name, @PathVariable String course) {
        List<StudentResponseDto> responseDtoList = studentService.getListByNameAndCourse(name, course);
        return ResponseEntity.status(HttpStatus.OK).body(responseDtoList);
    }

    @GetMapping("/age-between")
    public ResponseEntity<List<StudentResponseDto>> getByAgeBetween(
            @RequestParam Integer min,
            @RequestParam Integer max) {

        return ResponseEntity.ok(studentService.findStudentsByAgeBetween(min, max));
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentResponseDto>> getAll() {
        List<StudentResponseDto> responseDtoList = studentService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(responseDtoList);
    }

}

