package com.example.college_management_system.services;

import com.example.college_management_system.entities.ProfessorEntity;
import com.example.college_management_system.entities.StudentEntity;
import com.example.college_management_system.entities.SubjectEntity;
import com.example.college_management_system.repositories.ProfessorRepository;
import com.example.college_management_system.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProfessorService {

    ProfessorRepository professorRepository;
    StudentRepository studentRepository;

    public ProfessorEntity createProfessor(ProfessorEntity Professor) {
       return  professorRepository.save(Professor);
    }

    public List<ProfessorEntity> getProfessor() {
        return professorRepository.findAll();
    }

    public ProfessorEntity addStudent(Long professorId, Long studentId) {



            ProfessorEntity prof =  professorRepository.findById(professorId)
                    .orElseThrow(() -> new RuntimeException("Prof not found"));

            StudentEntity student =  studentRepository.findById(studentId)
                    .orElseThrow(() -> new RuntimeException("Professor not found"));

            prof.getRegisteredStudents().add(student);
            student.getProfessorsTaken().add(prof);

            return professorRepository.save(prof);


    }
}

