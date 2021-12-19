package com.example.recrutmenttool.models.entities;

import com.example.recrutmenttool.models.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "skills")
public class SkillEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    @NotBlank
    private String name;

    public SkillEntity() {
    }

    public SkillEntity(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
