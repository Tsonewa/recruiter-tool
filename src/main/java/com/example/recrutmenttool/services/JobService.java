package com.example.recrutmenttool.services;

import com.example.recrutmenttool.models.entities.JobEntity;

import java.util.List;

public interface JobService {
    List<JobEntity> getJobBySkillName(String skillName);

    void deleteJob(Long id);

    JobEntity createJob(JobEntity jobEntity);
}


