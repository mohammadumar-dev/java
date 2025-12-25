package com.example.demo.service;

import com.example.demo.dto.request.CreateStudentDTO;
import com.example.demo.dto.resposne.StudentResponseDto;
import com.example.demo.entity.Student;
import com.example.demo.exception.DuplicateResourceException;
import com.example.demo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentResponseDto createStudent(CreateStudentDTO dto) {

        if (studentRepository.existsByEmail(dto.getEmail())) {
            throw new DuplicateResourceException("Email already exists");
        }

        Student student = Student.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .email(dto.getEmail())
                .rollNumber(dto.getRollNumber())
                .course(dto.getCourse())
                .year(dto.getYear())
                .status("ACTIVE")
                .build();

        Student saved = studentRepository.save(student);

        return StudentResponseDto.from(saved);
    }

    public List<StudentResponseDto> getListByCourseAndStatus(String course, String status) {
        return studentRepository.findByCourseAndStatus(course, status);
    }

    public  List<StudentResponseDto> getListByYear(Integer year) {
        return studentRepository.findByYear(year);
    }

    public List<StudentResponseDto> getListByNameAndCourse(String name, String course) {
        return studentRepository.findByNameAndCourse(name, course);
    }

    public List<StudentResponseDto> findStudentsByAgeBetween(
            Integer minAge,
            Integer maxAge) {

        return studentRepository.findByAgeBetween(minAge, maxAge)
                .stream()
                .map(StudentResponseDto::from)
                .toList();
    }

    public List<StudentResponseDto> getAll() {
        return studentRepository.findAll()
                .stream()
                .map(StudentResponseDto::from)
                .toList();
    }

}

