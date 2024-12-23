package com.example.college_management_system.controllers;

import com.example.college_management_system.entities.StudentEntity;
import com.example.college_management_system.entities.StudentEntity;
import com.example.college_management_system.services.StudentService;
import com.example.college_management_system.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path="/student")
public class StudentController {

    StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentEntity> createstudent(@RequestBody StudentEntity student){
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @GetMapping
    public ResponseEntity<List<StudentEntity>>getstudent(){
        return ResponseEntity.ok(studentService.getStudent());
    }
}
