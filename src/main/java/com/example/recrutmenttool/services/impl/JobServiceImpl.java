package com.example.recrutmenttool.services.impl;

import com.example.recrutmenttool.models.entities.JobEntity;
import com.example.recrutmenttool.repositories.JobRepository;
import com.example.recrutmenttool.services.JobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<JobEntity> getJobBySkillName(String skillName) {

        return jobRepository.findAllBySkillsName(skillName);
    }

    @Override
    public void deleteJob(Long id) {

        jobRepository.deleteById(id);
    }

    @Override
    public JobEntity createJob(JobEntity jobEntity) {
        return jobRepository.save(jobEntity);
    }
}
