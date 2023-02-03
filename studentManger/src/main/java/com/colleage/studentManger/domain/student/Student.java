package com.colleage.studentManger.domain.student;

import com.colleage.studentManger.domain.score.Score;
import com.colleage.studentManger.domain.subject.Subject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    private String name;

    private String major;

    @OneToMany(mappedBy = "student")
    private List<Score> scores;

}
