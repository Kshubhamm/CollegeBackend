package com.example.college_management_system.controllers;

import com.example.college_management_system.entities.AdmissionEntity;
import com.example.college_management_system.entities.ProfessorEntity;
import com.example.college_management_system.entities.SubjectEntity;
import com.example.college_management_system.services.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping(path="/subject")
public class SubjectController {

    SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectEntity> createSubject(@RequestBody SubjectEntity Subject){
        return ResponseEntity.ok(subjectService.createSubject(Subject));
    }

    @GetMapping
    public ResponseEntity<List<SubjectEntity>>getSubject(){
        return ResponseEntity.ok(subjectService.getSubject());
    }

    @PutMapping("/{subjectId}/addProf/{profId}")
    public ResponseEntity<SubjectEntity> addProfessor(@PathVariable Long subjectId, @PathVariable Long profId){
        return ResponseEntity.ok(subjectService.addProfessor(subjectId,profId));

    }

    @PutMapping("/{subjectId}/addStudent/{studentId}")
    public ResponseEntity<SubjectEntity> addStudent(@PathVariable Long subjectId, @PathVariable Long studentId){
        return ResponseEntity.ok(subjectService.addStudent(subjectId,studentId));

    }
}