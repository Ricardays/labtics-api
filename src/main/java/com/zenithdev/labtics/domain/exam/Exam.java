package com.zenithdev.labtics.domain.exam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String unitOfMeasure;
    private String referenceValue;
    @Enumerated(EnumType.STRING)
    private ExamType type;
    @ElementCollection
    private List<String> options = new ArrayList<>();
//    @ManyToOne
//    private Study study;

}