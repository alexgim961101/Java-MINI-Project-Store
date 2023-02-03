package com.colleage.studentManger.service.student;

import com.colleage.studentManger.domain.student.Student;
import com.colleage.studentManger.domain.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student save(Student student) {
        Student studentEntity = studentRepository.save(student);
        return student;
    }
}
