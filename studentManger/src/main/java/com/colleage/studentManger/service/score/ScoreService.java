package com.colleage.studentManger.service.score;

import com.colleage.studentManger.domain.score.Score;
import com.colleage.studentManger.domain.score.ScoreRepository;
import com.colleage.studentManger.domain.student.Student;
import com.colleage.studentManger.domain.student.StudentRepository;
import com.colleage.studentManger.domain.subject.Subject;
import com.colleage.studentManger.domain.subject.SubjectRepository;
import com.colleage.studentManger.web.dto.ScoreEnrollDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScoreService {

    private static final Logger log = LoggerFactory.getLogger(ScoreService.class);

    private final ScoreRepository scoreRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    @Transactional
    public Score save(Long studentId, ScoreEnrollDto scoreEnrollDto) {

        Student studentEntity = studentRepository.findById(studentId).get();
        log.info("과목 이름 : {}", scoreEnrollDto.getTitle());
        Subject subjectEntity = subjectRepository.findByTitle(scoreEnrollDto.getTitle());
        log.info("과목 정보 : {}", subjectEntity);
        int point = scoreEnrollDto.getPoint();

        Score scoreEntity = scoreRepository.save(Score.builder()
                .student(studentEntity)
                .subject(subjectEntity)
                .point(point).build());

        return scoreEntity;
    }
}
