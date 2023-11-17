package com.example.verbasure.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class QuestionToF
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long q_id;

    private String question;

    private Boolean answer;

    public QuestionToF() {
    }

    public QuestionToF(String question, Boolean answer) {
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

    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }
}

