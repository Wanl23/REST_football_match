package com.ivanleschinsky.football_match.domain;

public class Game {
    private Team a;
    private Team b;
    private Integer goalsA;
    private Integer goalsB;

    public Game(Team a, Team b, Integer goalsA, Integer goalsB) {
        this.a = a;
        this.b = b;
        this.goalsA = goalsA;
        this.goalsB = goalsB;
    }

    public Team getA() {
        return a;
    }

    public void setA(Team a) {
        this.a = a;
    }

    public Team getB() {
        return b;
    }

    public void setB(Team b) {
        this.b = b;
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

    @Override
    public String toString() {
        return "Game: " + getA().getName() + " vs " + getB().getName() + " , score: " +
                getGoalsA() + " - " + getGoalsB();
    }
}
