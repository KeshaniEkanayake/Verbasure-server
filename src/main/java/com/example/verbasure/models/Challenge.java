package com.example.verbasure.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int challengeId;
    
    private String challengeTitle;
    private String challengeDescription;
    private String challengeImage;
    /*
     * 1 - Reading
     * 2 - Listening
     * 3 - Writing
     * 4 - Grammar
     */
    private int module;
    
    
    public Challenge() {
    }
    
    public Challenge(String challengeTitle, String challengeDescription, String challengeImage, int module) {
        this.challengeTitle = challengeTitle;
        this.challengeDescription = challengeDescription;
        this.challengeImage = challengeImage;
        this.module = module;
    }
    
    public int getChallengeId() {
        return challengeId;
    }
    
    public String getChallengeTitle() {
        return challengeTitle;
    }

    public void setChallengeTitle(String challengeTitle) {
        this.challengeTitle = challengeTitle;
    }

    public String getChallengeDescription() {
        return challengeDescription;
    }

    public void setChallengeDescription(String challengeDescription) {
        this.challengeDescription = challengeDescription;
    }

    public String getChallengeImage() {
        return challengeImage;
    }

    public void setChallengeImage(String challengeImage) {
        this.challengeImage = challengeImage;
    }

    public int getModule() {
        return module;
    }

    public void setModule(int module) {
        this.module = module;
    }
    
    
}
