package com.example.verbasure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.verbasure.models.Challenge;

public interface ChallengeRepository extends JpaRepository<Challenge, Integer> {
    List<Challenge> findByModule(int moduleId);
    @Query("SELECT c.challengeId FROM Challenge c WHERE c.module = ?1")
    List<Integer> findIdByModule(@Param("1") int moduleId);
}
