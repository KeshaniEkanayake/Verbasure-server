package com.example.verbasure.Configurations;

import com.example.verbasure.repositories.*;
import com.example.verbasure.models.*;
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
            Task task;
            Question question;

            // Reading challenge 1
            challenge = new Challenge();
            challenge.setChallengeTitle("Time to Relax");
            challenge.setChallengeDescription(
                    "Come and join our lunchtime yoga class with experienced yoga teacher Divya Bridge!\n" +
                            "When? Every Tuesday at 1.30 p.m.\n" +
                            "Where? Meeting Room 7\n" +
                            "How much? £10 for four 30-minute classes.\n" +
                            "What to bring? Comfortable clothes. Divya will provide the yoga mats.\n" +
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

            // Questions related to task 1 - Question and Answer
            question = new Question("Which day of the week does the Yoga class take place?", "Tuesday");
            question.setTask(task);
            questionRepository.save(question);

            question = new Question("How many classes can you take for £10?", "Four");
            question.setTask(task);
            questionRepository.save(question);

            question = new Question("What time will the class end?", "2 p.m.");
            question.setTask(task);
            questionRepository.save(question);

            question = new Question("What kind of clothes do you need to where to the class?",
                    "Comfortable");
            question.setTask(task);
            questionRepository.save(question);

            question = new Question("What do you need to send to Sam if you want to join?", "an email");
            question.setTask(task);
            questionRepository.save(question);

            // Task 2
            task = new Task();
            task.setChallenge(challenge);
            task.setQuestionType("trueOrFalse");
            task = taskRepository.save(task);
            // Questions related to task 2 - True or False
            question = new Question("Sam Holden is the Yoga teacher", "true");
            question.setTask(task);
            questionRepository.save(question);

            question = new Question("The Yoga class is once a week", "true");
            question.setTask(task);
            questionRepository.save(question);

            question = new Question("The class is at lunch time in room 7", "true");
            question.setTask(task);
            questionRepository.save(question);

            question = new Question("You need to bring yoga mats to the class", "false");
            question.setTask(task);
            questionRepository.save(question);

            question = new Question("The class cannot take 22 people", "false");
            question.setTask(task);
            questionRepository.save(question);

            // Task 3 - multiple choice
            task = new Task();
            task.setChallenge(challenge);
            task.setQuestionType("multipleChoice");
            task = taskRepository.save(task);
            // Questions related to task 3 - Multiple Choice
            question = new Question("What is the class called?", "Yoga");
            question.setTask(task);
            question.setAnswerOptions(new String[] { "Yoga", "Relax", "Lunchtime", "Meeting" });
            questionRepository.save(question);

            question = new Question("What time does the class start?", "1.30 p.m.");
            question.setTask(task);
            question.setAnswerOptions(new String[] { "1.30 p.m.", "1 p.m.", "2 p.m.", "12.30 p.m." });
            questionRepository.save(question);
            

            // Reading challenge 2
            /*
             * readingText2-departure.7785dd5e.jpg
             * An Airport Departures Board
             * Time Flight Destination Gate Remarks
             * 10:45 XZ 3265 Chennai 17 Departed
             * 10:50 SQ 0972 Amsterdam 23 Departed
             * 11:00 SQ 2509 Mexico City 19 Departed
             * 11:05 RT 9122 Buenos Aires 34 Cancelled
             * 11:10 XZ 6005 Los Angeles 05 Final call
             * 11:20 QE 0078 Beijing 33 Final call
             * 11:25 TY 2053 Christchurch 56 Delayed
             * 11:25 ER 7452 Seoul 25 Boarding
             * 11:30 XZ 0352 Moscow 12 Boarding
             * 11:35 XZ 0569 Kuala Lumpur 27 Gate change
             */
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
            /*
             * The plane isn't here now.
             * 
             * The plane is late.
             * 
             * The plane is not going to leave.
             * 
             * You can get on the plane now.
             * 
             * The plane is leaving very soon.
             * 
             * You need to go to a different place to get on the plane.
             * 
             * 
             */
        };
    }
}
