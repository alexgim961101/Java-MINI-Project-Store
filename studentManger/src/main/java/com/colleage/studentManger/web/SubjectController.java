package com.colleage.studentManger.web;

import com.colleage.studentManger.domain.subject.Subject;
import com.colleage.studentManger.service.subject.SubjectService;
import com.colleage.studentManger.web.dto.SubjectEnrollDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping()
    public ResponseEntity enrollSubject(SubjectEnrollDto subjectEnrollDto) {
        Subject subjectEntity = subjectService.save(subjectEnrollDto);
        return ResponseEntity.status(HttpStatus.OK).body(subjectEntity);
    }
}
