package com.example.college_management_system.services;

import com.example.college_management_system.entities.StudentEntity;
import com.example.college_management_system.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    StudentRepository studentRepository;

    public StudentEntity createStudent(StudentEntity Student) {
       return  studentRepository.save(Student);
    }

    public List<StudentEntity> getStudent() {
        return studentRepository.findAll();
    }
}
