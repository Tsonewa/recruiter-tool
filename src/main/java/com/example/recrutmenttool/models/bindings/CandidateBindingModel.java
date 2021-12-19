package com.example.recrutmenttool.models.bindings;

import java.time.LocalDate;
import java.util.List;

public class CandidateBindingModel {

    private String firstName;
    private String lastName;
    private String email;
    private String bio;
    private LocalDate birthDate;
    private List<SkillBindingModel> skills;
    private RecruiterBindingModel recruiter;

    public CandidateBindingModel() {
    }

    public CandidateBindingModel(String firstName, String lastName, String email, String bio, LocalDate birthDate, List<SkillBindingModel> skills, RecruiterBindingModel recruiter) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.bio = bio;
        this.birthDate = birthDate;
        this.skills = skills;
        this.recruiter = recruiter;
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

    public List<SkillBindingModel> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillBindingModel> skills) {
        this.skills = skills;
    }

    public RecruiterBindingModel getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(RecruiterBindingModel recruiter) {
        this.recruiter = recruiter;
    }
}
