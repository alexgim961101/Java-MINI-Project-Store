package com.colleage.studentManger.web.dto;

import com.colleage.studentManger.domain.score.Score;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentInfoDto {
    
    private String name;
    
    private String major;

    private int count;  // 과목 수

    private List<Score> scoreList;
    
    private int avg;   // 평균
    
}
