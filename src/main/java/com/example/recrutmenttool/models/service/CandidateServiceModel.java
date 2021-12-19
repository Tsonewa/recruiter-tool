package com.example.recrutmenttool.models.service;

import com.example.recrutmenttool.models.bindings.RecruiterBindingModel;
import com.example.recrutmenttool.models.bindings.SkillBindingModel;

import java.time.LocalDate;
import java.util.List;

public class CandidateServiceModel {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String bio;
    private LocalDate birthDate;
    private List<SkillServiceModel> skills;
    private RecruiterServiceModel recruiter;

    public CandidateServiceModel() {
    }

    public CandidateServiceModel(Long id, String firstName, String lastName, String email, String bio, LocalDate birthDate, List<SkillServiceModel> skills, RecruiterServiceModel recruiter) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.bio = bio;
        this.birthDate = birthDate;
        this.skills = skills;
        this.recruiter = recruiter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<SkillServiceModel> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillServiceModel> skills) {
        this.skills = skills;
    }

    public RecruiterServiceModel getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(RecruiterServiceModel recruiter) {
        this.recruiter = recruiter;
    }
}
