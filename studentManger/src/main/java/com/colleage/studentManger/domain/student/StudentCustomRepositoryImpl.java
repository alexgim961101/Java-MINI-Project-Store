package com.colleage.studentManger.domain.student;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class StudentCustomRepositoryImpl implements StudentCustomRepository {
    private final JPAQueryFactory queryFactory;
    private QStudent qStudent;
    @Override
    public Page<Student> findAll(Pageable pageable) {
        qStudent = QStudent.student;
        queryFactory.select(qStudent).from(qStudent);
        return null;
    }
}
