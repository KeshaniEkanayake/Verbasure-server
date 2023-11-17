package com.example.verbasure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.verbasure.models.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
    
}
