package com.example.college_management_system.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AdmissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer fees;

    @OneToOne
    @JoinColumn(name = "records")
    private StudentEntity admittedStudent;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AdmissionEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getFees(), that.getFees());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFees());
    }
}
