package com.colleage.studentManger.web.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class SubjectEnrollDto {
    @Pattern(regexp = "^[ㄱ-ㅎ|가-힣]+$")
    private String title;
}
