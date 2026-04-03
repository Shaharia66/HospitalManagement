package com.pro.HospitalMng.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pro.HospitalMng.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        name="unique_Patient_email",columnNames = {"email"}
                ),
                @UniqueConstraint(
                        name="unique_Patient_name_birthDate",columnNames = {"name","birthDate"}
                )
        },
        indexes = {
                @Index(name="idx_Patient_birthDate",columnList = "birthdate")
        }
)

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 40, nullable = false)
    private String name;

//    @ToString.Exclude
    private LocalDate birthDate;

    private String email;

    private String gender;
    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn
    private  Insurance insurance;

    @OneToMany(mappedBy = "patient",cascade = {CascadeType.ALL},orphanRemoval = true)
    @ToString.Exclude
    private List<Appointment> appointment;
}
