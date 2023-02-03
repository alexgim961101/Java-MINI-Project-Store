package com.colleage.studentManger.web;

import com.colleage.studentManger.domain.score.Score;
import com.colleage.studentManger.service.score.ScoreService;
import com.colleage.studentManger.web.dto.ScoreEnrollDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/score")
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreService scoreService;

    @PostMapping("/{studentId}")
    public ResponseEntity enrollScore(@PathVariable Long studentId, ScoreEnrollDto scoreEnrollDto) {
        Score scoreEntity = scoreService.save(studentId, scoreEnrollDto);
        return ResponseEntity.status(HttpStatus.OK).body(scoreEntity);
    }

}
