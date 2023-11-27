package com.example.verbasure.controllers;

import com.example.verbasure.models.QuestionQnA;
import com.example.verbasure.repositories.QuestionQnARepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class QuestionQnAController {

    public QuestionQnAController(QuestionQnARepository repository) {
        this.repository = repository;
    }

    private final QuestionQnARepository repository;

    @GetMapping("/qnaquestions")
    public List<QuestionQnA> getQnAQuestions() {
        return repository.findAll();
    }

}
