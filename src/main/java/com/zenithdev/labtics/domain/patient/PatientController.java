package com.zenithdev.labtics.domain.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Patient> getPatientById(@PathVariable Long id) {
        return patientRepository.findById(id);
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            Patient updatedPatient = patient.get();
            updatedPatient.setName(patientDetails.getName());
            updatedPatient.setLastName(patientDetails.getLastName());
            updatedPatient.setDni(patientDetails.getDni());
            updatedPatient.setEmail(patientDetails.getEmail());
            updatedPatient.setDateOfBirth(patientDetails.getDateOfBirth());
            updatedPatient.setAddress(patientDetails.getAddress());
            updatedPatient.setLastVisitDate(patientDetails.getLastVisitDate());
            return patientRepository.save(updatedPatient);
        } else {
            throw new RuntimeException("Patient not found with id " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientRepository.deleteById(id);
    }

}