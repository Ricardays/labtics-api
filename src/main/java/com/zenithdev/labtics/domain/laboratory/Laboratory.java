package com.zenithdev.labtics.domain.laboratory;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Laboratory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String shortAddress;
    private String longAddress;
    private String rif;
    private String phoneNumber;
    private String website;

}