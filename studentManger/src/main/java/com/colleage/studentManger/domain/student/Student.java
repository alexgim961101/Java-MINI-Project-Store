package com.colleage.studentManger.domain.student;

import com.colleage.studentManger.domain.score.Score;
import com.colleage.studentManger.domain.subject.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
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


    @ToString.Exclude
    @OneToMany(mappedBy = "student")
    private List<Score> scores;

}
