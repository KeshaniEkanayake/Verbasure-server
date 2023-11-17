package com.example.verbasure.Configurations;

import com.example.verbasure.repositories.*;
import com.example.verbasure.models.*;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(ChallengeRepository challengeRepository, TaskRepository taskRepository,
            QuestionRepository questionRepository) {

        return args -> {

            // Reading challenge 1
            Challenge challenge1 = new Challenge();
            challenge1.setChallengeTitle("Time to Relax");
            challenge1.setChallengeDescription(
                    "Come and join our lunchtime yoga class with experienced yoga teacher Divya Bridge!\n" +
                            "When? Every Tuesday at 1.30 p.m.\n" +
                            "Where? Meeting Room 7\n" +
                            "How much? £10 for four 30-minute classes.\n" +
                            "What to bring? Comfortable clothes. Divya will provide the yoga mats.\n" +
                            "How to join? Write to Sam at");
            challenge1.setChallengeImage("reading1.jpg");
            challenge1.setModule(1);
            challenge1 = challengeRepository.save(challenge1);

            // Tasks related to challenge 1

            // Task 1
            Task task1 = new Task();
            task1.setChallenge(challenge1);
            task1.setQuestionType("questionAndAnswer");
            task1 = taskRepository.save(task1);

            Question question;
            // Questions related to task 1 - Question and Answer
            question= new Question("Which day of the week does the Yoga class take place?", "Tuesday");
            question.setTask(task1);
            questionRepository.save(question);

            question= new Question("How many classes can you take for £10?", "Four");
            question.setTask(task1);
            questionRepository.save(question);

            question = new Question("What time will the class end?", "2 p.m.");
            question.setTask(task1);
            questionRepository.save(question);

            question = new Question("What kind of clothes do you need to where to the class?",
                    "Comfortable");
            question.setTask(task1);
            questionRepository.save(question);

            question = new Question("What do you need to send to Sam if you want to join?", "an email");
            question.setTask(task1);
            questionRepository.save(question);

            // Task 2
            Task task2 = new Task();
            task2.setChallenge(challenge1);
            task2.setQuestionType("trueOrFalse");
            task2 = taskRepository.save(task2);
            // Questions related to task 2 - True or False
            question = new Question("Sam Holden is the Yoga teacher", "True");
            question.setTask(task2);
            questionRepository.save(question);

            question = new Question("The Yoga class is once a week", "True");
            question.setTask(task2);
            questionRepository.save(question);

            question = new Question("The class is at lunch time in room 7", "True");
            question.setTask(task2);
            questionRepository.save(question);

            question = new Question("You need to bring yoga mats to the class", "False");
            question.setTask(task2);
            questionRepository.save(question);

            question = new Question("The class cannot take 22 people", "False");
            question.setTask(task2);
            questionRepository.save(question);
        };
    }
}
