package com.example.recrutmenttool.web;

import com.example.recrutmenttool.models.bindings.JobBindingModel;
import com.example.recrutmenttool.models.bindings.RecruiterBindingModel;
import com.example.recrutmenttool.models.entities.CandidateEntity;
import com.example.recrutmenttool.models.entities.JobEntity;
import com.example.recrutmenttool.services.JobService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class JobRestController {

    private final JobService jobService;
    private final ModelMapper modelMapper;

    public JobRestController(JobService jobService, ModelMapper modelMapper) {
        this.jobService = jobService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/jobs/{skillName}")
    List<JobBindingModel> getJobBySkillName(@PathVariable String skillName) {

        return jobService.getJobBySkillName(skillName).stream()
                .map(r -> modelMapper.map(r, JobBindingModel.class))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/jobs",
            consumes = "application/json", produces = "application/json")
    JobEntity newJob(@RequestBody JobEntity jobEntity) {
        return jobService.createJob(jobEntity);
    }

    @DeleteMapping("/jobs/{id}")
    void deleteJob(@PathVariable Long id) {

        jobService.deleteJob(id);
    }
}
