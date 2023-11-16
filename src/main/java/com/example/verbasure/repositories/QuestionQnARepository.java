package com.example.verbasure.repositories;
import com.example.verbasure.models.QuestionQnA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface QuestionQnARepository extends JpaRepository<QuestionQnA, Long> {

}
