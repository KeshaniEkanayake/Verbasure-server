package com.example.verbasure.DTO;

import java.util.List;

import com.example.verbasure.models.Challenge;
import com.example.verbasure.models.Task;

public class ChallengeDTO {
    public int challengeId;
    public String challengeTitle;
    public String challengeDescription;
    public String challengeImage;
    public List<TaskDTO> tasks;

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }

    public ChallengeDTO() {
    }

    public static ChallengeDTO challengeDTOFromChallenge(Challenge challenge) {
        ChallengeDTO challengeDTO = new ChallengeDTO();
        challengeDTO.challengeId = challenge.getChallengeId();
        challengeDTO.challengeTitle = challenge.getChallengeTitle();
        challengeDTO.challengeDescription = challenge.getChallengeDescription();
        challengeDTO.challengeImage = challenge.getChallengeImage();
        List<Task> tasks = challenge.getTasks();
        List<TaskDTO> taskDTOs = TaskDTO.createTaskDTOList(tasks);
        challengeDTO.setTasks(taskDTOs);
        return challengeDTO;
    }
}
