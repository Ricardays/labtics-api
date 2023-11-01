package com.zenithdev.labtics.domain.laboratory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/laboratories")
public class LaboratoryController {
    private final LaboratoryRepository laboratoryRepository;

    @Autowired
    public LaboratoryController(LaboratoryRepository laboratoryRepository) {
        this.laboratoryRepository = laboratoryRepository;
    }

    @GetMapping
    public List<Laboratory> getAllLaboratories() {
        return laboratoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Laboratory> getLaboratoryById(@PathVariable Long id) {
        return laboratoryRepository.findById(id);
    }

    @PostMapping
    public Laboratory createLaboratory(@RequestBody Laboratory laboratory) {
        return laboratoryRepository.save(laboratory);
    }

    @PutMapping("/{id}")
    public Laboratory updateLaboratory(@PathVariable Long id, @RequestBody Laboratory laboratoryDetails) {
        Optional<Laboratory> laboratory = laboratoryRepository.findById(id);
        if (laboratory.isPresent()) {
            Laboratory updatedLaboratory = laboratory.get();
            updatedLaboratory.setName(laboratoryDetails.getName());
            updatedLaboratory.setShortAddress(laboratoryDetails.getShortAddress());
            updatedLaboratory.setLongAddress(laboratoryDetails.getLongAddress());
            updatedLaboratory.setRif(laboratoryDetails.getRif());
            updatedLaboratory.setPhoneNumber(laboratoryDetails.getPhoneNumber());
            updatedLaboratory.setWebsite(laboratoryDetails.getWebsite());
            // Set other fields as needed
            return laboratoryRepository.save(updatedLaboratory);
        } else {
            throw new RuntimeException("Laboratory not found with id " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteLaboratory(@PathVariable Long id) {
        laboratoryRepository.deleteById(id);
    }
}
