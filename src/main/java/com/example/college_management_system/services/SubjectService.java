package com.example.college_management_system.services;

import com.example.college_management_system.entities.AdmissionEntity;
import com.example.college_management_system.entities.ProfessorEntity;
import com.example.college_management_system.entities.StudentEntity;
import com.example.college_management_system.entities.SubjectEntity;
import com.example.college_management_system.repositories.ProfessorRepository;
import com.example.college_management_system.repositories.StudentRepository;
import com.example.college_management_system.repositories.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubjectService {

    SubjectRepository subjectRepository;
    ProfessorRepository professorRepository;
    StudentRepository studentRepository;
    public SubjectEntity createSubject(SubjectEntity Subject) {
       return  subjectRepository.save(Subject);
    }

    public List<SubjectEntity> getSubject() {
        return subjectRepository.findAll();
    }

    public SubjectEntity addProfessor(Long subjectId, Long profId) {

        SubjectEntity subject =  subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        ProfessorEntity professor =  professorRepository.findById(profId)
                .orElseThrow(() -> new RuntimeException("Professor not found"));

        subject.setProfessor(professor);
        professor.getSubjects().add(subject);
        return subjectRepository.save(subject);
    }

    public SubjectEntity addStudent(Long subjectId, Long studentId) {

        SubjectEntity subject =  subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        StudentEntity student =  studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Professor not found"));

        subject.getCohort().add(student);
        student.getSubjectTaken().add(subject);

        return subjectRepository.save(subject);

    }
}
