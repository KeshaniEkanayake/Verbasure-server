package com.example.verbasure.models;

import jakarta.persistence.*;

@Entity
public class QuestionQnA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long q_id;

    private String question;

    private String answer;

    public QuestionQnA() {
    }

    public QuestionQnA(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public long getQ_id() {
        return q_id;
    }

    public void setQ_id(long q_id) {
        this.q_id = q_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
