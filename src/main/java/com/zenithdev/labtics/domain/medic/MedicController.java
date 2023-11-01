package com.zenithdev.labtics.domain.medic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medics")
public class MedicController {
    private final MedicRepository medicRepository;

    @Autowired
    public MedicController(MedicRepository medicRepository) {
        this.medicRepository = medicRepository;
    }

    @GetMapping
    public List<Medic> getAllMedics() {
        return medicRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Medic> getMedicById(@PathVariable Long id) {
        return medicRepository.findById(id);
    }

    @PostMapping
    public Medic createMedic(@RequestBody Medic medic) {
        return medicRepository.save(medic);
    }

    @PutMapping("/{id}")
    public Medic updateMedic(@PathVariable Long id, @RequestBody Medic medicDetails) {
        Optional<Medic> medic = medicRepository.findById(id);
        if (medic.isPresent()) {
            Medic updatedMedic = medic.get();
            updatedMedic.setName(medicDetails.getName());
            updatedMedic.setLastName(medicDetails.getLastName());
            updatedMedic.setDni(medicDetails.getDni());
            updatedMedic.setEmail(medicDetails.getEmail());
            updatedMedic.setDateOfBirth(medicDetails.getDateOfBirth());
            updatedMedic.setAddress(medicDetails.getAddress());
            updatedMedic.setRegistrationDate(medicDetails.getRegistrationDate());
            updatedMedic.setLastAppointmentDate(medicDetails.getLastAppointmentDate());
            updatedMedic.setPhoneNumber(medicDetails.getPhoneNumber());
            updatedMedic.setLicenseNumber(medicDetails.getLicenseNumber());
            return medicRepository.save(updatedMedic);
        } else {
            throw new RuntimeException("Medic not found with id " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteMedic(@PathVariable Long id) {
        medicRepository.deleteById(id);
    }
}
