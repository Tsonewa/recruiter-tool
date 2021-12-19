package com.example.recrutmenttool.services;

import com.example.recrutmenttool.models.entities.RecruiterEntity;
import com.example.recrutmenttool.models.service.RecruiterServiceModel;

import java.util.List;

public interface RecruiterService {

    boolean existRecruiterByEmail(String email);

    RecruiterEntity findRecruiterByEmail(String email);

    RecruiterEntity createRecruiter(RecruiterEntity newRecruiter);

    List<RecruiterEntity> getRecruiterByLevel(Integer level);
}

