package com.zenithdev.labtics.domain.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/exams")
public class ExamController {
    private final ExamRepository examRepository;

    @Autowired
    public ExamController(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @GetMapping
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Exam> getExamById(@PathVariable Long id) {
        return examRepository.findById(id);
    }

    @PostMapping
    public Exam createExam(@RequestBody Exam exam) {
        return examRepository.save(exam);
    }

    @PutMapping("/{id}")
    public Exam updateExam(@PathVariable Long id, @RequestBody Exam examDetails) {
        Optional<Exam> exam = examRepository.findById(id);
        if (exam.isPresent()) {
            Exam updatedExam = exam.get();
            updatedExam.setName(examDetails.getName());
            updatedExam.setUnitOfMeasure(examDetails.getUnitOfMeasure());
            updatedExam.setReferenceValue(examDetails.getReferenceValue());
            updatedExam.setType(examDetails.getType());
            updatedExam.setOptions(examDetails.getOptions());
            return examRepository.save(updatedExam);
        } else {
            throw new RuntimeException("Exam not found with id " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteExam(@PathVariable Long id) {
        examRepository.deleteById(id);
    }
}
