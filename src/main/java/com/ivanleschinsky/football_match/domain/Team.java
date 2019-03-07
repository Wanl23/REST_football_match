package com.ivanleschinsky.football_match.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity()
public class Team implements Comparable<Team>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer wins;
    private Integer losses;
    private Integer draws;
    private Integer poits;

    public Team(String name) {
        this.name = name;
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

    public Integer getPoits() {
        return poits = points();
    }

    public void setPoits(Integer poits) {
        this.poits = poits;
    }

    private Integer points() {
        if (wins != null && draws != null) {
            return wins * 3 + draws;
        }
        return 0;
    }

    @Override
    public int compareTo(Team t) {
        return t.points() - this.points();
    }
}
