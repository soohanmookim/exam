package com.example.exam.v1.subject.application;

import com.example.exam.exception.NoDataException;
import com.example.exam.v1.student.application.StudentService;
import com.example.exam.v1.subject.domain.SubjectRepository;
import com.example.exam.v1.subject.domain.entity.Subject;
import com.example.exam.v1.subject.dto.SubjectDeleteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SubjectService {

	private final SubjectRepository subjectRepository;
	private final StudentService studentService;

	public SubjectDeleteResponse deleteById(Long id ) {
		Subject subject = subjectRepository.findById(id).orElseThrow(() -> new NoDataException("존재하지 않는 과목 ID"));
		subjectRepository.deleteById(id);
		//subject.getGradeList().stream().forEach(a -> studentService.u);
		return new SubjectDeleteResponse(id);
	}
	
}