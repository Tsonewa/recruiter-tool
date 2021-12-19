package com.example.recrutmenttool.models.entities;

import com.example.recrutmenttool.models.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "recruiters")
public class RecruiterEntity extends BaseEntity implements Serializable {

    @Column(name = "first_name", nullable = false)
    @NotBlank
    private String firstName;
    @Column(name = "last_name", nullable = false)
    @NotBlank
    private String lastName;
    @Column(nullable = false)
    @Email
    @NotBlank
    private String email;
    @Column
    private String country;
    @Column
    private Integer experience = 1;
//    @OneToMany(mappedBy = "recruiter", targetEntity = CandidateEntity.class)
//    private List<CandidateEntity> candidates;

    public RecruiterEntity() {
    }

    public RecruiterEntity(Long id, String firstName, String lastName, String email, String country, Integer experience, List<CandidateEntity> candidates) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.experience = experience;
//        this.candidates = candidates;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

//    public List<CandidateEntity> getCandidates() {
//        return candidates;
//    }
//
//    public void setCandidates(List<CandidateEntity> candidates) {
//        this.candidates = candidates;
//    }
}

