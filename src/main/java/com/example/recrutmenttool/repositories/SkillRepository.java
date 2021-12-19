package com.example.recrutmenttool.repositories;

import com.example.recrutmenttool.models.entities.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<SkillEntity, Long> {

    boolean existsByName(String name);

    SkillEntity findByName(String name);
}
