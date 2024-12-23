package com.example.college_management_system.services;

import com.example.college_management_system.entities.AdmissionEntity;
import com.example.college_management_system.entities.StudentEntity;
import com.example.college_management_system.repositories.AdmissionRepository;
import com.example.college_management_system.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdmissionService {

    AdmissionRepository admissionRepository;
    StudentRepository studentRepository;

    public AdmissionEntity createAdmission(AdmissionEntity admission) {
       return  admissionRepository.save(admission);
    }

    public List<AdmissionEntity> getAdmission() {
        return admissionRepository.findAll();
    }

    public AdmissionEntity addStudent(Long admissionId ,Long studentId) {

        StudentEntity student =  studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        AdmissionEntity record =  admissionRepository.findById(admissionId)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        record.setAdmittedStudent(student);
        return admissionRepository.save(record);

    }
}
