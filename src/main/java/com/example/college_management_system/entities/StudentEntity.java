package com.example.college_management_system.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "cohort")
    @JsonIgnore
    private Set<SubjectEntity> subjectTaken;

    @OneToOne(mappedBy = "admittedStudent")
    @JsonIgnore
    AdmissionEntity admission;

    @ManyToMany(mappedBy = "registeredStudents")
    @JsonIgnore
    private Set<ProfessorEntity> professorsTaken;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StudentEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
