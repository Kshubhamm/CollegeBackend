package com.example.college_management_system.controllers;

import com.example.college_management_system.entities.ProfessorEntity;
import com.example.college_management_system.entities.SubjectEntity;
import com.example.college_management_system.services.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path="/prof")
public class ProfessorController {

    ProfessorService professorService;

    @PostMapping
    public ResponseEntity<ProfessorEntity> createProfessor(@RequestBody ProfessorEntity professor){
        return ResponseEntity.ok(professorService.createProfessor(professor));
    }

    @GetMapping
    public ResponseEntity<List<ProfessorEntity>>getProfessor(){
        return ResponseEntity.ok(professorService.getProfessor());
    }

    @PutMapping("/{professorId}/addStudent/{studentId}")
    public ResponseEntity<ProfessorEntity> addStudent(@PathVariable Long professorId, @PathVariable Long studentId){
        return ResponseEntity.ok(professorService.addStudent(professorId,studentId));

    }
}


