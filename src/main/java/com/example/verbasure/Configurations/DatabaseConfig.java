package com.example.verbasure.Configurations;
import com.example.verbasure.models.QuestionQnA;
import com.example.verbasure.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
    class LoadDatabase {

        @Bean
        CommandLineRunner initDatabase(QuestionQnARepository repository) {

            return args -> {
                QuestionQnA bilbo = new QuestionQnA("Bilbo Baggins", "burglar");
                System.out.println("Preloading " + repository.save(bilbo));

                QuestionQnA frodo = new QuestionQnA("Frodo Baggins", "thief");
                System.out.println("Preloading " + repository.save(frodo));
            };
        }
    }

