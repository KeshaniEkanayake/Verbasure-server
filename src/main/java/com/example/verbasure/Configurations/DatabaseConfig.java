package com.example.verbasure.Configurations;

import com.example.verbasure.repositories.*;
import com.example.verbasure.models.*;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

        @Bean
        CommandLineRunner initDatabase(ChallengeRepository challengeRepository, TaskRepository taskRepository,
                        QuestionRepository questionRepository) {

                return args -> {
                        Challenge challenge;
                        Task task = new Task();
                        Question question = new Question();
                        Map<String, String> questionAndAnswer;

                        // Reading challenge 1
                        challenge = new Challenge();
                        challenge.setChallengeTitle("Time to Relax");
                        challenge.setChallengeDescription(
                                        "Come and join our lunchtime yoga class with experienced yoga teacher Divya Bridge!\n"
                                                        +
                                                        "When? Every Tuesday at 1.30 p.m.\n" +
                                                        "Where? Meeting Room 7\n" +
                                                        "How much? £10 for four 30-minute classes.\n" +
                                                        "What to bring? Comfortable clothes. Divya will provide the yoga mats.\n"
                                                        +
                                                        "How to join? Write to Sam at");
                        challenge.setChallengeImage("reading1.jpg");
                        challenge.setModule(1);
                        challenge = challengeRepository.save(challenge);

                        // Tasks related to challenge 1

                        // Task 1
                        task = new Task();
                        task.setChallenge(challenge);
                        task.setQuestionType("questionAndAnswer");
                        task = taskRepository.save(task);

                        questionAndAnswer = new HashMap<>();
                        questionAndAnswer.put("Which day of the week does the Yoga class take place?", "Tuesday");
                        questionAndAnswer.put("How many classes can you take for £10?", "Four");
                        questionAndAnswer.put("What time will the class end?", "2 p.m.");
                        questionAndAnswer.put("What kind of clothes do you need to where to the class?", "Comfortable");
                        questionAndAnswer.put("What do you need to send to Sam if you want to join?", "an email");
                        
                        final Task taskCopy1 = task;
                        questionAndAnswer.forEach((questionText, answerText) -> {
                                Question inQuestion = new Question(questionText, answerText);
                                inQuestion.setTask(taskCopy1);
                                questionRepository.save(inQuestion);
                        });

                        // Task 2
                        task = new Task();
                        task.setChallenge(challenge);
                        task.setQuestionType("trueOrFalse");
                        task = taskRepository.save(task);
                        // Questions related to task 2 - True or False
                        questionAndAnswer = new HashMap<>();
                        questionAndAnswer.put("Sam Holden is the Yoga teacher", "True");
                        questionAndAnswer.put("The Yoga class is once a week", "True");
                        questionAndAnswer.put("The class is at lunch time in room 7", "True");
                        questionAndAnswer.put("You need to bring yoga mats to the class", "False");
                        questionAndAnswer.put("The class cannot take 22 people", "False");
                        final Task taskCopy2 = task;
                        questionAndAnswer.forEach((questionText, answerText) -> {
                                Question inQuestion = new Question(questionText, answerText);
                                inQuestion.setTask(taskCopy2);
                                questionRepository.save(inQuestion);
                        });

                        // Reading challenge 2
                        challenge = new Challenge();
                        challenge.setChallengeTitle("Departures");
                        challenge.setChallengeDescription(
                                        "An Airport Departures Board\n" +
                                                        "Time\tFlight\tDestination\tGate\tRemarks\n" +
                                                        "10:45\tXZ 3265\tChennai\t17\tDeparted\n" +
                                                        "10:50\tSQ 0972\tAmsterdam\t23\tDeparted\n" +
                                                        "11:00\tSQ 2509\tMexico City\t19\tDeparted\n" +
                                                        "11:05\tRT 9122\tBuenos Aires\t34\tCancelled\n" +
                                                        "11:10\tXZ 6005\tLos Angeles\t05\tFinal call\n" +
                                                        "11:20\tQE 0078\tBeijing\t33\tFinal call\n" +
                                                        "11:25\tTY 2053\tChristchurch\t56\tDelayed\n" +
                                                        "11:25\tER 7452\tSeoul\t25\tBoarding\n" +
                                                        "11:30\tXZ 0352\tMoscow\t12\tBoarding\n" +
                                                        "11:35\tXZ 0569\tKuala Lumpur\t27\tGate change\n");
                        challenge.setChallengeImage("readingText2-departure.jpg");
                        challenge.setModule(1);
                        challenge = challengeRepository.save(challenge);

                        // Tasks related to challenge 2

                        // Task 1
                        task = new Task();
                        task.setChallenge(challenge);
                        task.setQuestionType("questionAndAnswer");
                        task = taskRepository.save(task);
                        // Questions related to task 1 - Question and Answer
                        questionAndAnswer = new HashMap<>();
                        questionAndAnswer.put("The plane isn't here now.", "Departed");
                        questionAndAnswer.put("The plane is late.", "Delayed");
                        questionAndAnswer.put("The plane is not going to leave.", "Cancelled");
                        questionAndAnswer.put("You can get on the plane now.", "Boarding");
                        questionAndAnswer.put("The plane is leaving very soon.", "Final call");
                        questionAndAnswer.put("You need to go to a different place to get on the plane.",
                                        "Gate change");
                        final Task taskCopy = task;
                        questionAndAnswer.forEach((questionText, answerText) -> {
                                Question inQuestion = new Question(questionText, answerText);
                                inQuestion.setTask(taskCopy);
                                questionRepository.save(inQuestion);
                        });

                };
        }
}
