package com.example.verbasure.controllers;

import com.example.verbasure.DTO.ChallengeDTO;
import com.example.verbasure.models.Challenge;
import com.example.verbasure.models.Task;
import com.example.verbasure.repositories.ChallengeRepository;
import com.example.verbasure.repositories.QuestionRepository;
import com.example.verbasure.repositories.TaskRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ChallengeController {

    public final ChallengeRepository challengeRepository;
    public final TaskRepository taskRepository;
    public final QuestionRepository questionRepository;

    public ChallengeController(ChallengeRepository challengeRepository, TaskRepository taskRepository,
            QuestionRepository questionRepository) {
        this.challengeRepository = challengeRepository;
        this.taskRepository = taskRepository;
        this.questionRepository = questionRepository;
    }

    //get all challenge id's for reading
    @GetMapping("/reading")
    public Map<String, List<?>> getReading1Content() {
        List<Integer> challengeIds = challengeRepository.findIdByModule(1);
        Map<String, List<?>> map = new HashMap<>();
        map.put("challengeIds", challengeIds);
        return map;
    }

    @GetMapping("/writing")
    public Map<String, List<?>> getWriting1Content() {
        List<Integer> challengeIds = challengeRepository.findIdByModule(2);
        Map<String, List<?>> map = new HashMap<>();
        map.put("challengeIds", challengeIds);
        return map;
    }

    @GetMapping("/speaking")
    public Map<String, List<?>> getSpeaking1Content() {
        List<Integer> challengeIds = challengeRepository.findIdByModule(3);
        Map<String, List<?>> map = new HashMap<>();
        map.put("challengeIds", challengeIds);
        return map;
    }

    @GetMapping("/grammar")
    public Map<String, List<?>> getListening1Content() {
        List<Integer> challengeIds = challengeRepository.findIdByModule(4);
        Map<String, List<?>> map = new HashMap<>();
        map.put("challengeIds", challengeIds);
        return map;
    }
    //get challenge by id
    @GetMapping("/challenge/{id}")
    public ChallengeDTO getChallengeById(@PathVariable int id) {
        Challenge challenge = challengeRepository.findById(id).get();
        ChallengeDTO challengeDTO = ChallengeDTO.challengeDTOFromChallenge(challenge);
        return challengeDTO;
    }
}
