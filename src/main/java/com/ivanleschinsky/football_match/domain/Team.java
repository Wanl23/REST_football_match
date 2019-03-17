package com.ivanleschinsky.football_match.domain;

import javax.persistence.*;

@Entity
public class Team implements Comparable<Team>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer wins;
    private Integer losses;
    private Integer draws;
    private Integer points;

    public Team(String name) {
        this.name = name;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
        this.points = 0;
    }

    public Team() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public Integer getDraws() {
        return draws;
    }

    public void setDraws(Integer draws) {
        this.draws = draws;
    }

    public Integer getPoints() {
        if (wins != null && draws != null) {
            this.points = wins * 3 + draws;
        } else this.points = 0;
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }


    @Override
    public int compareTo(Team t) {
        return  t.getPoints() - this.getPoints();
    }
}
