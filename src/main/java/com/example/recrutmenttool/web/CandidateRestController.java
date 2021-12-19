package com.example.recrutmenttool.web;

import com.example.recrutmenttool.models.bindings.CandidateBindingModel;
import com.example.recrutmenttool.models.entities.CandidateEntity;
import com.example.recrutmenttool.models.service.CandidateServiceModel;
import com.example.recrutmenttool.services.CandidateService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class CandidateRestController {

    private final CandidateService candidateService;
    private final ModelMapper modelMapper;

    public CandidateRestController(CandidateService candidateService, ModelMapper modelMapper) {
        this.candidateService = candidateService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/candidates")
    List<CandidateEntity> all() {
        return candidateService.getAllCandidates();
    }

    @GetMapping("/candidates/{id}")
    @Transactional
    CandidateBindingModel one(@PathVariable Long id) {

        return modelMapper.map(candidateService.getCandidateById(id),
                CandidateBindingModel.class);
    }

    @PostMapping(value = "/candidates",
            consumes = "application/json", produces = "application/json")
    CandidateEntity newCandidate(@RequestBody CandidateEntity candidateEntity) {
        return candidateService.createCandidate(candidateEntity);
    }

    @PutMapping("/candidates/{id}")
    @Transactional
    CandidateEntity replaceCandidate(@RequestBody CandidateEntity newCandidate, @PathVariable Long id) {

        CandidateServiceModel candidateById = candidateService.getCandidateById(id);

        CandidateEntity c = modelMapper.map(candidateById, CandidateEntity.class);

        newCandidate.setId(id);

        if(c != null){
            return candidateService.updateCandidate(newCandidate);
            } else {
            return candidateService.createCandidate(newCandidate);
            }
    }



    @DeleteMapping("/candidates/{id}")
    void deleteCandidate(@PathVariable Long id) {
        candidateService.deleteCandidate(id);
    }
}
