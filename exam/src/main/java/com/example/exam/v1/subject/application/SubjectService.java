package com.example.exam.v1.subject.application;

import com.example.exam.exception.NoDataException;
import com.example.exam.v1.grade.domain.entity.Grade;
import com.example.exam.v1.student.application.StudentService;
import com.example.exam.v1.student.domain.entity.Student;
import com.example.exam.v1.subject.domain.SubjectRepository;
import com.example.exam.v1.subject.domain.entity.Subject;
import com.example.exam.v1.subject.dto.SubjectDeleteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class SubjectService {

    private final SubjectRepository subjectRepository;
//    private final StudentRepository studentRepository;
//    private final GradeRepository gradeRepository;

    private final StudentService studentService;

    //	public void updateAverage(Subject subject) {
//		List<Grade> list = gradeRepository.findBySubject(subject);
//
//		Integer total = Optional.of(list).orElseGet(()-> Collections.singletonList(Grade.builder().score(0).build())).stream().mapToInt(Grade::getScore).sum();
//		Long count = Optional.of(list).orElse(Arrays.asList(new Grade())).stream().count();
//		subject.setAverage(BigDecimal.valueOf(total).divide(BigDecimal.valueOf(count), 2, RoundingMode.CEILING));
//	}
    public Subject findById(Long id) {
        return subjectRepository.findById(id).orElseThrow(() -> new NoDataException("존재하지 않는 과목 ID"));
    }

    public SubjectDeleteResponse deleteById(Long id) {
        Subject subject = findById(id);

        List<Grade> gradeList = subject.getGradeList();
        List<Student> students = gradeList.stream().map(Grade::getStudent).collect(Collectors.toList());
        subjectRepository.deleteById(id);
        students.stream().forEach(student -> student.updateAverage());
        return new SubjectDeleteResponse(id);
    }

}