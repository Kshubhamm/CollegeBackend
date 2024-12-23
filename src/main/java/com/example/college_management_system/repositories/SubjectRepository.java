package com.example.college_management_system.repositories;

import com.example.college_management_system.entities.AdmissionEntity;
import com.example.college_management_system.entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity,Long> {
}
