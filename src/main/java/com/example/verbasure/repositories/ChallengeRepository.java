package com.example.verbasure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.verbasure.models.Challenge;

public interface ChallengeRepository extends JpaRepository<Challenge, Integer> {

}
