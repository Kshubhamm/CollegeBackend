package com.example.college_management_system.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //Owner of this relationship
    @ManyToOne
    @JoinColumn(name = "prof_id")
    @JsonIgnore
    private ProfessorEntity professor;

    @ManyToMany
    @JoinTable(

            name = "Subject_Student",
            joinColumns  = @JoinColumn(name = "Subject_id"),
            inverseJoinColumns = @JoinColumn(name = "Student_id")
    )
    private Set<StudentEntity> cohort;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SubjectEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
