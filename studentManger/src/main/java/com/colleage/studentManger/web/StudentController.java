package com.colleage.studentManger.web;

import com.colleage.studentManger.domain.student.Student;
import com.colleage.studentManger.service.student.StudentService;
import com.colleage.studentManger.web.dto.StudentEnrollDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity enroll(@Valid StudentEnrollDto studentEnrollDto) {
        Student student = studentEnrollDto.toEntity();
        Student studentEntity = studentService.save(student);
        return ResponseEntity.status(HttpStatus.OK).body(studentEntity);
    }
}
