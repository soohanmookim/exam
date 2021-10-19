package com.example.exam.v1.student.application;

import com.example.exam.exception.NoDataException;
import com.example.exam.v1.grade.application.GradeService;
import com.example.exam.v1.grade.domain.entity.Grade;
import com.example.exam.v1.student.domain.StudentRepository;
import com.example.exam.v1.student.domain.entity.Student;
import com.example.exam.v1.subject.domain.entity.Subject;
import com.example.exam.v1.subject.dto.SubjectDeleteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;

    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new NoDataException("존재하지 않는 학생 ID"));
    }

    public SubjectDeleteResponse deleteById(Long id) {
        Student student = findById(id);

        List<Grade> gradeList = student.getGradeList();
        List<Subject> subjects = gradeList.stream().map(Grade::getSubject).collect(Collectors.toList());
        studentRepository.deleteById(id);
        subjects.stream().forEach(subject -> subject.updateAverage());
        return new SubjectDeleteResponse(id);
    }
}
