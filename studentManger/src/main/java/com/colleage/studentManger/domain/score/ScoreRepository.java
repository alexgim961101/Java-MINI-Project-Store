package com.colleage.studentManger.domain.score;

import com.colleage.studentManger.domain.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findAllByStudent(Student student);
}
