package com.example.recrutmenttool.services.impl;

import com.example.recrutmenttool.exceptions.CandidateNotFoundException;
import com.example.recrutmenttool.models.entities.CandidateEntity;
import com.example.recrutmenttool.models.entities.RecruiterEntity;
import com.example.recrutmenttool.models.entities.SkillEntity;
import com.example.recrutmenttool.models.service.CandidateServiceModel;
import com.example.recrutmenttool.repositories.CandidateRepository;
import com.example.recrutmenttool.services.CandidateService;
import com.example.recrutmenttool.services.RecruiterService;
import com.example.recrutmenttool.services.SkillService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final ModelMapper modelMapper;
    private final RecruiterService recruiterService;
    private final SkillService skillService;

    public CandidateServiceImpl(CandidateRepository candidateRepository, ModelMapper modelMapper, RecruiterService recruiterService, SkillService skillService) {
        this.candidateRepository = candidateRepository;
        this.modelMapper = modelMapper;
        this.recruiterService = recruiterService;
        this.skillService = skillService;
    }

    @Override
    public CandidateServiceModel getCandidateById(Long id) {

        return candidateRepository.findCandidateEntityById(id)
                .map(c -> modelMapper.map(c, CandidateServiceModel.class))
                .orElseThrow(() -> new CandidateNotFoundException(id));
    }

    @Override
    public CandidateEntity createCandidate(CandidateEntity candidateEntity) {

        if(recruiterService.existRecruiterByEmail(candidateEntity.getRecruiter().getEmail())){
            RecruiterEntity recruiter = recruiterService.findRecruiterByEmail(candidateEntity.getRecruiter().getEmail());

            if(recruiter.getExperience() < 5){
                recruiter.setExperience(recruiter.getExperience() + 1);
                recruiterService.createRecruiter(recruiter);
            } else {
                RecruiterEntity newRecruiter = new RecruiterEntity();
                newRecruiter.setFirstName(candidateEntity.getRecruiter().getFirstName());
                newRecruiter.setLastName(candidateEntity.getRecruiter().getLastName());
                newRecruiter.setEmail(candidateEntity.getRecruiter().getEmail());
                newRecruiter.setCountry(candidateEntity.getRecruiter().getCountry());

                recruiter = recruiterService.createRecruiter(newRecruiter);
            }
            candidateEntity.setRecruiter(recruiter);

            candidateEntity.getSkills()
                    .forEach(s -> {
                        if(!skillService.existSkillByName(s.getName())){
                            skillService.createSkill(s.getName());
                        }
                    });
        }
        return candidateRepository.save(candidateEntity);
    }

    @Override
    public List<CandidateEntity> getAllCandidates() {
        return candidateRepository.findAllCandidates();
    }

    @Override
    public boolean existCandidateById(Long id) {

        return candidateRepository.existsById(id);
    }

    @Override
    public CandidateEntity updateCandidate(CandidateEntity c) {

        return candidateRepository.save(c);
    }

    @Override
    public void deleteCandidate(Long id) {

        candidateRepository.deleteById(id);
    }
}
