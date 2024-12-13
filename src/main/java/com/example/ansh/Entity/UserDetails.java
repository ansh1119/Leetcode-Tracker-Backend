package com.example.ansh.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;


@Document
public class UserDetails {

    private String status;
    private String message;
    private int totalSolved;
    private int totalQuestions;
    private int easySolved;
    private int totalEasy;
    private int mediumSolved;
    private int totalMedium;
    private int hardSolved;
    private int totalHard;
    private double acceptanceRate;
    private int ranking;
    private int contributionPoints;
    private int reputation;
    private Map<Long, Integer> submissionCalendar;

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTotalSolved() {
        return totalSolved;
    }

    public void setTotalSolved(int totalSolved) {
        this.totalSolved = totalSolved;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getEasySolved() {
        return easySolved;
    }

    public void setEasySolved(int easySolved) {
        this.easySolved = easySolved;
    }

    public int getTotalEasy() {
        return totalEasy;
    }

    public void setTotalEasy(int totalEasy) {
        this.totalEasy = totalEasy;
    }

    public int getMediumSolved() {
        return mediumSolved;
    }

    public void setMediumSolved(int mediumSolved) {
        this.mediumSolved = mediumSolved;
    }

    public int getTotalMedium() {
        return totalMedium;
    }

    public void setTotalMedium(int totalMedium) {
        this.totalMedium = totalMedium;
    }

    public int getHardSolved() {
        return hardSolved;
    }

    public void setHardSolved(int hardSolved) {
        this.hardSolved = hardSolved;
    }

    public int getTotalHard() {
        return totalHard;
    }

    public void setTotalHard(int totalHard) {
        this.totalHard = totalHard;
    }

    public double getAcceptanceRate() {
        return acceptanceRate;
    }

    public void setAcceptanceRate(double acceptanceRate) {
        this.acceptanceRate = acceptanceRate;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getContributionPoints() {
        return contributionPoints;
    }

    public void setContributionPoints(int contributionPoints) {
        this.contributionPoints = contributionPoints;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public Map<Long, Integer> getSubmissionCalendar() {
        return submissionCalendar;
    }

    public void setSubmissionCalendar(Map<Long, Integer> submissionCalendar) {
        this.submissionCalendar = submissionCalendar;
    }
}

