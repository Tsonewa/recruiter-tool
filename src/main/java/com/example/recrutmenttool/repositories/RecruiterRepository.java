package com.example.recrutmenttool.repositories;

import com.example.recrutmenttool.models.entities.RecruiterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Repository
public interface RecruiterRepository extends JpaRepository<RecruiterEntity, Long> {

    boolean existsByEmail(@Email @NotBlank String email);

    RecruiterEntity findByEmail(@Email @NotBlank String email);

    List<RecruiterEntity> findAllByExperience(Integer experience);

}
