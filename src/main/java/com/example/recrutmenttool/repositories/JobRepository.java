package com.example.recrutmenttool.repositories;

import com.example.recrutmenttool.models.entities.JobEntity;
import com.example.recrutmenttool.models.entities.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Long> {

    @Query("select j from JobEntity j LEFT JOIN FETCH j.skills s where s.name=:skillName")
    List<JobEntity> findAllBySkillsName(@Param("skillName") String skillName);
}
