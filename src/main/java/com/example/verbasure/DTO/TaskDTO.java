package com.example.verbasure.DTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.verbasure.models.Question;
import com.example.verbasure.models.Task;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskDTO {
    public int taskId;
    public String questionType;
    public List<Question> questions;
    public List<String> answers;

    public TaskDTO() {
    }

    public static List<TaskDTO> createTaskDTOList(List<Task> tasks) {
        List<TaskDTO> taskDTOs = new ArrayList<>();
        for (Task task : tasks) {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.taskId = task.getTaskId();
            taskDTO.questionType = task.getQuestionType();
            List<Question> questions = task.getQuestions();
            List<String> answerList = new ArrayList<>();
            for (Question question : questions) {
                answerList.add(question.getCorrectAnswer());
            }
            Collections.shuffle(questions);
            taskDTO.questions = questions;
            if (taskDTO.questionType.equals("questionAndAnswer")) {
                Collections.shuffle(answerList);
                taskDTO.answers = answerList;
            }
            taskDTOs.add(taskDTO);
        }
        return taskDTOs;
    }

}
