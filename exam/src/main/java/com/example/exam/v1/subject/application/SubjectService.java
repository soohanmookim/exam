package com.example.exam.v1.subject.application;

import org.springframework.stereotype.Service;

import com.example.exam.exception.NoDataException;
import com.example.exam.v1.subject.domain.SubjectRepository;
import com.example.exam.v1.subject.dto.SubjectDeleteResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubjectService {

	private final SubjectRepository subjectRepository;

	public SubjectDeleteResponse deleteById(Long id ) {
		subjectRepository.findById(id).orElseThrow(() -> new NoDataException("존재하지 않는 과목 ID"));
		subjectRepository.deleteById(id);
		
		return new SubjectDeleteResponse(id);
	}
	
}