package com.colleage.studentManger.web.dto;

import com.colleage.studentManger.domain.student.Student;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class StudentEnrollDto {

    @NotBlank
    private String name;

    @NotBlank
    private String major;

    public Student toEntity() {
        return Student.builder()
                .name(name)
                .major(major).build();
    }
}
