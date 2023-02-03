package com.colleage.studentManger.service.student;

import com.colleage.studentManger.domain.score.Score;
import com.colleage.studentManger.domain.score.ScoreRepository;
import com.colleage.studentManger.domain.student.Student;
import com.colleage.studentManger.domain.student.StudentRepository;
import com.colleage.studentManger.web.dto.StudentInfoDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private static final Logger log = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;
    private final ScoreRepository scoreRepository;

    @Transactional
    public Student save(Student student) {
        Student studentEntity = studentRepository.save(student);
        log.info("엔티티 값 : {}", studentEntity.toString());
        return studentEntity;
    }

    public List<StudentInfoDto> readAll() {
        List<Student> studentEntityList = studentRepository.findAll();
        List<StudentInfoDto> list = new ArrayList<>();

        for(Student student : studentEntityList) {
            List<Score> scoreEntityList = scoreRepository.findAllByStudent(student);

            int sum = 0;
            for(Score score : scoreEntityList) {
                sum += score.getPoint();
            }
            int avg = sum / scoreEntityList.size();

            list.add(StudentInfoDto.builder()
                    .name(student.getName())
                    .major(student.getMajor())
                    .count(scoreEntityList.size())
                    .scoreList(scoreEntityList)
                    .avg(avg).build());
        }

        return list;
    }
}
