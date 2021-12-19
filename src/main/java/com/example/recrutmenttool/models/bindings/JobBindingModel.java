package com.example.recrutmenttool.models.bindings;

import com.example.recrutmenttool.models.entities.SkillEntity;

import java.util.List;

public class JobBindingModel {

    private String title;
    private String description;
    private Double salary;
    private List<SkillBindingModel> skills;

    public JobBindingModel() {
    }

    public JobBindingModel(String title, String description, Double salary, List<SkillBindingModel> skills) {
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.skills = skills;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<SkillBindingModel> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillBindingModel> skills) {
        this.skills = skills;
    }
}
