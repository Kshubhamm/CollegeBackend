package com.example.college_management_system.controllers;

import com.example.college_management_system.entities.AdmissionEntity;
import com.example.college_management_system.repositories.AdmissionRepository;
import com.example.college_management_system.services.AdmissionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/admission")
@AllArgsConstructor
public class AdmissionController {

    AdmissionService admissionService;

    @PostMapping
    public ResponseEntity<AdmissionEntity>createAdmission(@RequestBody AdmissionEntity admission){
        return ResponseEntity.ok(admissionService.createAdmission(admission));
    }

    @GetMapping
    public ResponseEntity<List<AdmissionEntity>>getAdmission(){
        return ResponseEntity.ok(admissionService.getAdmission());
    }

    @PutMapping("/{admissionId}/addStudent/{studentId}")
    public ResponseEntity<AdmissionEntity> addStudent(@PathVariable Long admissionId,@PathVariable Long studentId){
        return ResponseEntity.ok(admissionService.addStudent(admissionId,studentId));

    }

}
