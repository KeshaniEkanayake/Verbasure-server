package com.example.verbasure.controllers;

import com.example.verbasure.models.Challenge;
import com.example.verbasure.models.Question;
import com.example.verbasure.models.QuestionQnA;
import com.example.verbasure.models.Task;
import com.example.verbasure.repositories.ChallengeRepository;
import com.example.verbasure.repositories.QuestionQnARepository;
import com.example.verbasure.repositories.QuestionRepository;
import com.example.verbasure.repositories.TaskRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionQnAController {

    public final ChallengeRepository challengeRepository;
    public final TaskRepository taskRepository;
    public final QuestionRepository questionRepository;

    public QuestionQnAController(ChallengeRepository challengeRepository, TaskRepository taskRepository,
            QuestionRepository questionRepository) {
        this.challengeRepository = challengeRepository;
        this.taskRepository = taskRepository;
        this.questionRepository = questionRepository;
    }

    @GetMapping("/reading/1")
    public Challenge getReading1Content() {
        //find the first challenges content
        Challenge challenge = challengeRepository.findById(1).get();
        challenge.getTasks();
        return challenge;
    }

    @GetMapping("/reading/1/task")
    public Task getReading1Questions() {
        Task task = taskRepository.findById(1).get();
        task.getQuestions();
        return task;
    }
}
