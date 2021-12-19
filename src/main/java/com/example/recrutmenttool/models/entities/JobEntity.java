package com.example.recrutmenttool.models.entities;

import com.example.recrutmenttool.models.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "jobs")
public class JobEntity extends BaseEntity {

    @Column(nullable = false)
    @NotBlank
    private String title;
    @Lob
    @Column(nullable = false)
    @NotBlank
    private String description;
    @DecimalMin(value = "0.0")
    private Double salary;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<SkillEntity> skills;

    public JobEntity() {
    }

    public JobEntity(Long id, String title, String description, Double salary, List<SkillEntity> skills) {
        super(id);
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

    public List<SkillEntity> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillEntity> skills) {
        this.skills = skills;
    }
}
