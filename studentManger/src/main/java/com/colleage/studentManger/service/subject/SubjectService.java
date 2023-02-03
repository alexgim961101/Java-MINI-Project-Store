package com.colleage.studentManger.service.subject;

import com.colleage.studentManger.domain.subject.Subject;
import com.colleage.studentManger.domain.subject.SubjectRepository;
import com.colleage.studentManger.web.dto.SubjectEnrollDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;


    public Subject save(SubjectEnrollDto subjectEnrollDto) {
        Subject subjectEntity = subjectRepository.save(Subject.builder()
                .title(subjectEnrollDto.getTitle())
                .build());

        return subjectEntity;
    }
}
