package com.colleage.studentManger.domain.score;

import com.colleage.studentManger.domain.student.Student;
import com.colleage.studentManger.domain.subject.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
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

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne(targetEntity = Student.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    /**
     * 오류 발생 지점
     * LAZY로 할 경우 No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor 이런 에러 발생
     * EAGER로 바꾸니 해결이 가능했다. but 이유는 아직 모름 / 프록시 초기화 문제
     * */
    @ManyToOne(targetEntity = Subject.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    private int point;
}
