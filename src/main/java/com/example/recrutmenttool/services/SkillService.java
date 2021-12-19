package com.example.recrutmenttool.services;

import com.example.recrutmenttool.models.bindings.SkillBindingModel;
import com.example.recrutmenttool.models.entities.SkillEntity;
import com.example.recrutmenttool.models.service.SkillServiceModel;

import java.util.List;

public interface SkillService {

    boolean existSkillByName(String name);

    SkillEntity createSkill(String name);

    SkillServiceModel getSkillById(Long id);

    List<SkillServiceModel> getAllSkills();
}


