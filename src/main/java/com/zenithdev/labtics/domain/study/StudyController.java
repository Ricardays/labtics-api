package com.zenithdev.labtics.domain.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/studies")
public class StudyController {
    private final StudyRepository studyRepository;

    @Autowired
    public StudyController(StudyRepository studyRepository) {
        this.studyRepository = studyRepository;
    }

    @GetMapping
    public List<Study> getAllStudies() {
        return studyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Study> getStudyById(@PathVariable Long id) {
        return studyRepository.findById(id);
    }

    @PostMapping
    public Study createStudy(@RequestBody Study study) {
        return studyRepository.save(study);
    }

    @PutMapping("/{id}")
    public Study updateStudy(@PathVariable Long id, @RequestBody Study studyDetails) {
        Optional<Study> study = studyRepository.findById(id);
        if (study.isPresent()) {
            Study updatedStudy = study.get();
            updatedStudy.setName(studyDetails.getName());
            return studyRepository.save(updatedStudy);
        } else {
            throw new RuntimeException("Study not found with id " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteStudy(@PathVariable Long id) {
        studyRepository.deleteById(id);
    }
}
