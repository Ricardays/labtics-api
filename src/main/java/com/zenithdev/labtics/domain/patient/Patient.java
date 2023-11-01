package com.zenithdev.labtics.domain.patient;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private String dni;
    private String email;
    private LocalDate dateOfBirth;
    private String address;
    private LocalDate lastVisitDate;



}