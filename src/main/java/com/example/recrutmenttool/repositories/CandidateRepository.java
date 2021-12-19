package com.example.recrutmenttool.repositories;

import com.example.recrutmenttool.models.entities.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateEntity, Long> {

    @Query("select c from CandidateEntity c LEFT JOIN FETCH c.skills where c.id = :id")
    Optional<CandidateEntity> findCandidateEntityById(@Param("id") Long id);

    @Query("select c from CandidateEntity c LEFT JOIN FETCH c.skills")
    List<CandidateEntity> findAllCandidates();

}
