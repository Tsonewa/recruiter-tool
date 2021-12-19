package com.example.recrutmenttool.services.impl;

import com.example.recrutmenttool.models.entities.RecruiterEntity;
import com.example.recrutmenttool.models.service.CandidateServiceModel;
import com.example.recrutmenttool.models.service.RecruiterServiceModel;
import com.example.recrutmenttool.repositories.RecruiterRepository;
import com.example.recrutmenttool.services.RecruiterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecruiterServiceImpl implements RecruiterService {

    private final RecruiterRepository recruiterRepository;

    public RecruiterServiceImpl(RecruiterRepository recruiterRepository) {
        this.recruiterRepository = recruiterRepository;
    }

    @Override
    public boolean existRecruiterByEmail(String email) {

        return recruiterRepository.existsByEmail(email);
    }

    @Override
    public RecruiterEntity findRecruiterByEmail(String email) {
        return recruiterRepository.findByEmail(email);
    }

    @Override
    public RecruiterEntity createRecruiter(RecruiterEntity newRecruiter) {
        return recruiterRepository.save(newRecruiter);
    }

    @Override
    public List<RecruiterEntity> getRecruiterByLevel(Integer level) {

        return recruiterRepository.findAllByExperience(level);
    }
}
