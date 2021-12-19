package com.example.recrutmenttool.web;

import com.example.recrutmenttool.models.bindings.CandidateBindingModel;
import com.example.recrutmenttool.models.bindings.RecruiterBindingModel;
import com.example.recrutmenttool.services.RecruiterService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RecruiterRestController {

    private final ModelMapper modelMapper;
    private final RecruiterService recruiterService;

    public RecruiterRestController(ModelMapper modelMapper, RecruiterService recruiterService) {
        this.modelMapper = modelMapper;
        this.recruiterService = recruiterService;
    }

    @GetMapping("/recruiters/{level}")
    @Transactional
    List<RecruiterBindingModel> getRecruitersByLevel(@PathVariable Integer level) {

        return recruiterService.getRecruiterByLevel(level).stream()
                .map(r -> modelMapper.map(r, RecruiterBindingModel.class))
                .collect(Collectors.toList());
    }
}
