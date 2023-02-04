package com.colleage.studentManger.web.dto;

import com.colleage.studentManger.domain.score.Score;
import com.colleage.studentManger.domain.subject.Subject;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Data
public class ScoreEnrollDto {

    @Pattern(regexp = "^[ㄱ-ㅎ|가-힣]+$")    //
    private String title;

    @Min(0)
    @Max(100)
    private int point;
}
