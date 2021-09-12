package com.example.exam.v1.subject.presentation;

import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exam.exception.NoDataException;
import com.example.exam.v1.subject.domain.SubjectRepository;
import com.example.exam.v1.subject.domain.entity.Subject;
import com.example.exam.v1.subject.dto.SubjectDeleteResponse;
import com.example.exam.v1.subject.dto.SubjectRequest;
import com.example.exam.v1.subject.dto.SubjectResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/subject")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectRepository subjectRepository;

    @PostMapping
    @Description("과목 추가")
    public ResponseEntity<SubjectResponse> add(@RequestBody SubjectRequest request) {
        return ResponseEntity.ok(
                SubjectResponse.of(
                        subjectRepository.save(Subject.of(request)))
        );
    }

    @GetMapping("/{id}")
    @Description("특정 과목의 평균 점수 조회")
    public ResponseEntity<SubjectResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(
                SubjectResponse.of(
                        subjectRepository.findById(id)
                                .orElseThrow(() -> new NoDataException("존재하지 않는 과목 ID"))));
    }
    
   @DeleteMapping("/{id}")
   @Description("특정 과목 삭제")
   public ResponseEntity<SubjectDeleteResponse> deleteById(@PathVariable Long id) {
	   
       subjectRepository.findById(id).orElseThrow(() -> new NoDataException("존재하지 않는 과목 ID"));
	   subjectRepository.deleteById(id);
	   
	   return ResponseEntity.ok(new SubjectDeleteResponse(id));
   }
}


