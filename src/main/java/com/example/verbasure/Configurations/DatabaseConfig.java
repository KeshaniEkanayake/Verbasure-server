package com.example.verbasure.Configurations;

import com.example.verbasure.repositories.*;
import com.example.verbasure.models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

        @Autowired
        private ChallengeRepository challengeRepository;

        @Autowired
        private TaskRepository taskRepository;

        @Autowired
        private QuestionRepository questionRepository;

        private Challenge creatChallenge(String challengeTitle, String challengeDescription, String challengeImage,
                        int module) {
                Challenge challenge = new Challenge();
                challenge.setChallengeTitle(challengeTitle);
                challenge.setChallengeDescription(challengeDescription);
                challenge.setChallengeImage(challengeImage);
                challenge.setModule(module);
                return challengeRepository.save(challenge);
        }

        private Task createTask(Challenge challenge, String questionType) {
                Task task = new Task();
                task.setChallenge(challenge);
                task.setQuestionType(questionType);
                return taskRepository.save(task);
        }

        private void createQuestion(Task task, String questionText, String answerText) {
                Question question = new Question(questionText, answerText);
                question.setTask(task);
                questionRepository.save(question);
        }

        private void createQuestion(Task task, String questionText, String answerText, String[] answerOptions) {
                Question question = new Question(questionText, answerText);
                question.setTask(task);
                question.setAnswerOptions(answerOptions);
                questionRepository.save(question);
        }

        private void createTaskWithQuestions(Challenge challenge, String questionType, String[] questionTexts,
                        String[] answerTexts) {
                Task task = createTask(challenge, questionType);
                for (int i = 0; i < questionTexts.length; i++) {
                        createQuestion(task, questionTexts[i], answerTexts[i]);
                }
        }

        private void createTaskWithQuestions(Challenge challenge, String questionType, String[] questionTexts,
                        String[] answerTexts, String[][] answerOptions) {
                Task task = createTask(challenge, questionType);
                for (int i = 0; i < questionTexts.length; i++) {
                        createQuestion(task, questionTexts[i], answerTexts[i], answerOptions[i]);
                }
        }

        @Bean
        CommandLineRunner initDatabase() {

                return args -> {
                        Challenge challenge;
                        // Reading challenge 1

                        challenge = creatChallenge("Time to Relax",
                                        "Come and join our lunchtime yoga class with experienced yoga teacher Divya Bridge!\n"
                                                        +
                                                        "When? Every Tuesday at 1.30 p.m.\n" +
                                                        "Where? Meeting Room 7\n" +
                                                        "How much? £10 for four 30-minute classes.\n" +
                                                        "What to bring? Comfortable clothes. Divya will provide the yoga mats.\n"
                                                        +
                                                        "How to join? Write to Sam atat Sam.Holden@example.com\n" +
                                                        "We can only take a maximum of 20 in the room, so book now!",
                                        "reading1.jpg", 1);

                        // Tasks related to challenge 1

                        // Task 1
                        createTaskWithQuestions(challenge, "questionAndAnswer",
                                        new String[] {
                                                        "Which day of the week does the Yoga class take place?",
                                                        "How many classes can you take for £10?",
                                                        "What time will the class end?",
                                                        "What kind of clothes do you need to where to the class?",
                                                        "What do you need to send to Sam if you want to join?" },
                                        new String[] {
                                                        "Tuesday",
                                                        "Four",
                                                        "2 p.m.",
                                                        "Comfortable",
                                                        "an email" });

                        // Task 2
                        createTaskWithQuestions(challenge, "trueOrFalse", new String[] {
                                        "Sam Holden is the Yoga teacher",
                                        "The Yoga class is once a week",
                                        "The class is at lunch time in room 7",
                                        "You need to bring yoga mats to the class",
                                        "The class cannot take 22 people"
                        }, new String[] {
                                        "True",
                                        "True",
                                        "True",
                                        "False",
                                        "False"
                        });

                        // Reading challenge 2
                        challenge = creatChallenge(
                                        "Departures",
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
                                                        "11:35\tXZ 0569\tKuala Lumpur\t27\tGate change\n",
                                        "readingText2-departure.jpg", 1);

                        // Tasks related to challenge 2

                        // Task 1
                        createTaskWithQuestions(
                                        challenge,
                                        "questionAndAnswer",
                                        new String[] {
                                                        "The plane isn't here now.",
                                                        "The plane is late.",
                                                        "The plane is not going to leave.",
                                                        "You can get on the plane now.",
                                                        "The plane is leaving very soon.",
                                                        "You need to go to a different place to get on the plane."
                                        },
                                        new String[] {
                                                        "Departed",
                                                        "Delayed",
                                                        "Cancelled",
                                                        "Boarding",
                                                        "Final call",
                                                        "Gate change"
                                        });

                        // challenge 3
                        challenge = creatChallenge("Holiday Home Adverts", "City Flat\n" +
                                        "Beautiful two-bedroom city flat five minutes' walk from the cathedral. Fully equipped kitchen, living room with a large sofa and chairs, big TV and balcony. The balcony has space for four people to sit and gets the sun in the mornings, and the flat is light and warm. It has Wi-Fi and fast internet. The upstairs bedroom sleeps four people, with two double beds; the downstairs bedroom sleeps two in single beds. The flat is perfect for families and is near shops, bars and restaurants."
                                        +
                                        "Farmhouse\n" +
                                        "Four-bedroom farmhouse in the countryside. All of the four double bedrooms are en suite with luxury shower and bath. Farm kitchen with barbecue, tables and chairs outside. Great for groups of friends. The supermarket is half an hour by car and you can take a train from the village into the city. Escape from normal life for a few days as we have … NO INTERNET and you can only use mobile phones at the bottom of the garden!",
                                        "flat-farmhouse.jpg", 1);
                        // Task 1
                        createTaskWithQuestions(challenge, "multipleChoice", new String[] {
                                        "What is the main feature of the city flat's balcony?",
                                        "How many people can the upstairs bedroom in the city flat sleep?",
                                        "What is a notable feature of the farmhouse mentioned in the text?",
                                        "How is the farmhouse kitchen described?",
                                        "What is a unique aspect of the farmhouse mentioned in the text?",
                        }, new String[] {
                                        "It accomadates four people",
                                        "four",
                                        "En suite bedrooms",
                                        "Fully equipped",
                                        "NO INTERNET"
                        }, new String[][] {
                                        { "It has a barbecue area", "It accomadates four people", "It overlooks the cathedral",
                                                        "It gets the sun in the evenings" },
                                        { "two", "three", "four", "six" },
                                        { "Fast internet", "En suite bedrooms", "Proximity to the city", "Large TV" },
                                        { "Fully equipped", "With a balcony", "Near shops and restaurants",
                                                        "Only accessible by train" },
                                        { "Fully equipped", "With a balcony", "Near shops and restaurants",
                                                        "Only accessible by train" }
                        });
                };
        }
}