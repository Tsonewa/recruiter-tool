package com.example.recrutmenttool.services.impl;

import com.example.recrutmenttool.exceptions.SkillNotFoundExeption;
import com.example.recrutmenttool.models.entities.SkillEntity;
import com.example.recrutmenttool.models.service.SkillServiceModel;
import com.example.recrutmenttool.repositories.SkillRepository;
import com.example.recrutmenttool.services.SkillService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillServiceImpl implements SkillService {

    private final ModelMapper modelMapper;
  private final SkillRepository skillRepository;

    public SkillServiceImpl(ModelMapper modelMapper, SkillRepository skillRepository) {
        this.modelMapper = modelMapper;
        this.skillRepository = skillRepository;
    }

    @Override
    public boolean existSkillByName(String name) {

        return skillRepository.existsByName(name);
    }

    @Override
    public SkillEntity createSkill(String name) {

        SkillEntity newSkill = new SkillEntity();
        newSkill.setName(name);

        if(skillRepository.existsByName(name)){
            return skillRepository.findByName(name);
        }

        return skillRepository.save(newSkill);
    }

    @Override
    public SkillServiceModel getSkillById(Long id) {

        return  skillRepository.findById(id)
                .map(c -> modelMapper.map(c, SkillServiceModel.class))
                .orElseThrow(() -> new SkillNotFoundExeption(id));
    }

    @Override
    public List<SkillServiceModel> getAllSkills() {
        return skillRepository.findAll()
                .stream()
                .map(s -> modelMapper.map(s, SkillServiceModel.class))
                .collect(Collectors.toList());
    }
}
