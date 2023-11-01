package com.zenithdev.labtics.domain.result;


import com.zenithdev.labtics.domain.exam.Exam;
import com.zenithdev.labtics.domain.medic.Medic;
import com.zenithdev.labtics.domain.patient.Patient;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Medic medic;

//    @ManyToOne
//    private Laboratory laboratory;

    @ManyToOne
    private Exam exam;

    private String value;
    private String referenceValue;
    private String unitOfMeasure;

}