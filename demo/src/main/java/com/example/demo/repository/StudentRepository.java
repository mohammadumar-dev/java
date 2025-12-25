package com.example.demo.repository;

import com.example.demo.dto.resposne.StudentResponseDto;
import com.example.demo.entity.Student;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByEmail(@NotBlank @Email String email);

    List<StudentResponseDto> findByCourseAndStatus(String course, String status);

    List<StudentResponseDto> findByYear(Integer year);

    List<StudentResponseDto> findByNameAndCourse(String name, String course);

    @Query("""
    SELECT s
    FROM Student s
    WHERE s.age BETWEEN :min AND :max
""")
    List<Student> findByAgeBetween(
            @Param("min") Integer ageMin,
            @Param("max") Integer ageMax
    );

}
