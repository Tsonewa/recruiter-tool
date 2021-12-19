package com.example.recrutmenttool.models.entities;

import com.example.recrutmenttool.models.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "candidates")
public class CandidateEntity extends BaseEntity implements Serializable {

    @Column(name = "first_name", nullable = false)
    @NotBlank
    private String firstName;
    @Column(name = "last_name", nullable = false)
    @NotBlank
    private String lastName;
    @Email
    @Column(nullable = false, unique = true)
    @NotBlank
    private String email;
    @Lob
    @Column(nullable = false)
    private String bio;
    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-dd-mm")
    private LocalDate birthDate;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<SkillEntity> skills = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.PERSIST)
    private RecruiterEntity recruiter;

    public CandidateEntity() {
    }

    public CandidateEntity(Long id, String firstName, String lastName, String email, String bio, LocalDate birthDate, List<SkillEntity> skills, RecruiterEntity recruiter) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.bio = bio;
        this.birthDate = birthDate;
        this.skills = skills;
        this.recruiter = recruiter;
    }

    public RecruiterEntity getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(RecruiterEntity recruiter) {
        this.recruiter = recruiter;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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

    public List<SkillEntity> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillEntity> skills) {
        this.skills = skills;
    }
}
