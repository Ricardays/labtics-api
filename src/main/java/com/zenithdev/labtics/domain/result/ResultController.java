package com.zenithdev.labtics.domain.result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/results")
public class ResultController {
    private final ResultRepository resultRepository;

    @Autowired
    public ResultController(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @GetMapping
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Result> getResultById(@PathVariable Long id) {
        return resultRepository.findById(id);
    }

    @PostMapping
    public Result createResult(@RequestBody Result result) {
        return resultRepository.save(result);
    }

    @PutMapping("/{id}")
    public Result updateResult(@PathVariable Long id, @RequestBody Result resultDetails) {
        Optional<Result> result = resultRepository.findById(id);
        if (result.isPresent()) {
            Result updatedResult = result.get();
            updatedResult.setPatient(resultDetails.getPatient());
            updatedResult.setMedic(resultDetails.getMedic());
//            updatedResult.setLaboratory(resultDetails.getLaboratory());
            updatedResult.setExam(resultDetails.getExam());
            updatedResult.setValue(resultDetails.getValue());
            updatedResult.setReferenceValue(resultDetails.getReferenceValue());
            updatedResult.setUnitOfMeasure(resultDetails.getUnitOfMeasure());
            return resultRepository.save(updatedResult);
        } else {
            throw new RuntimeException("Result not found with id " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteResult(@PathVariable Long id) {
        resultRepository.deleteById(id);
    }
}

