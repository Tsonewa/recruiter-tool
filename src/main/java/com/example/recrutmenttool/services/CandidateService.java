package com.example.recrutmenttool.services;

import com.example.recrutmenttool.models.entities.CandidateEntity;
import com.example.recrutmenttool.models.service.CandidateServiceModel;

import java.util.List;

public interface CandidateService {

    CandidateServiceModel getCandidateById(Long id);

    CandidateEntity createCandidate(CandidateEntity candidateEntity);

    List<CandidateEntity> getAllCandidates();

    boolean existCandidateById(Long id);

    CandidateEntity updateCandidate(CandidateEntity c);

    void deleteCandidate(Long id);
}




