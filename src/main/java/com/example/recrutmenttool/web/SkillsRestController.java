package com.example.recrutmenttool.web;

import com.example.recrutmenttool.models.bindings.SkillBindingModel;
import com.example.recrutmenttool.models.entities.CandidateEntity;
import com.example.recrutmenttool.models.entities.SkillEntity;
import com.example.recrutmenttool.services.CandidateService;
import com.example.recrutmenttool.services.SkillService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class SkillsRestController {

    private final SkillService skillService;
    private final ModelMapper modelMapper;
    private final CandidateService candidateService;

    public SkillsRestController(SkillService skillService, ModelMapper modelMapper, CandidateService candidateService) {
        this.skillService = skillService;
        this.modelMapper = modelMapper;
        this.candidateService = candidateService;
    }

    @GetMapping("/skills/{id}")
    SkillBindingModel oneSkill(@PathVariable Long id) {

        return modelMapper.map(skillService.getSkillById(id),
                SkillBindingModel.class);
    }

    @GetMapping("/skills/active")
    @Transactional
    List<SkillBindingModel> activeSkills() {

        List<CandidateEntity> allCandidates = candidateService.getAllCandidates();

        Set<String> activeSkills = new HashSet<>();

        allCandidates.forEach(c -> {
            c.getSkills()
                    .forEach(s -> activeSkills.add(s.getName()));

        });

            return activeSkills.stream()
                    .map(e -> {
                        SkillBindingModel skill = new SkillBindingModel();
                        skill.setName(e);

                        return skill;
                    })
                    .collect(Collectors.toList());
        }
}
