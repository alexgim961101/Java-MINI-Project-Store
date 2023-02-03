package com.colleage.studentManger.web.dto;

import com.colleage.studentManger.domain.score.Score;
import com.colleage.studentManger.domain.subject.Subject;
import lombok.Data;

@Data
public class ScoreEnrollDto {

    private String title;

    private int point;
}
