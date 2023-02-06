package com.colleage.studentManger.domain.student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentCustomRepository  {
    Page<Student> findAll(Pageable pageable);
}
