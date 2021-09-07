package com.example.exam.v1.subject;

import com.example.exam.exception.NoDataException;
import com.example.exam.v1.subject.dto.SubjectRequest;
import com.example.exam.v1.subject.dto.SubjectResponse;
import com.example.exam.v1.subject.entity.Subject;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.NoAspectBoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/subject")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectRepository subjectRepository;

    @PostMapping
    public ResponseEntity<SubjectResponse> add(@ModelAttribute SubjectRequest request) {
        return ResponseEntity.ok(
                SubjectResponse.of(
                        subjectRepository.save(Subject.of(request)))
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(
                SubjectResponse.of(
                        subjectRepository.findById(id)
                                .orElseThrow(() -> new NoDataException("존재하지 않는 과목 ID"))));
    }
}


