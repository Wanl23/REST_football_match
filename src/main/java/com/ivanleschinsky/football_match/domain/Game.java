package com.ivanleschinsky.football_match.domain;

import javax.persistence.*;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String teamA;
    private String teamB;
    private Integer goalsA;
    private Integer goalsB;

    public Game(String teamA, String teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.goalsA = (int)(Math.random() * 10);
        this.goalsB = (int)(Math.random() * 10);
    }

    public Game() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public Integer getGoalsA() {
        return goalsA;
    }

    public void setGoalsA(Integer goalsA) {
        this.goalsA = goalsA;
    }

    public Integer getGoalsB() {
        return goalsB;
    }

    public void setGoalsB(Integer goalsB) {
        this.goalsB = goalsB;
    }

}
