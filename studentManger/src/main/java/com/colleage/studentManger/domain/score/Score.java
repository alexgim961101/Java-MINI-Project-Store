package com.colleage.studentManger.domain.score;

import com.colleage.studentManger.domain.student.Student;
import com.colleage.studentManger.domain.subject.Subject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "score")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "score_id")
    private Long id;

    @ManyToOne(targetEntity = Student.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(targetEntity = Subject.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
