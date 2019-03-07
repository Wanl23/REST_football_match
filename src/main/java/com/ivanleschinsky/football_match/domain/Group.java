package com.ivanleschinsky.football_match.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private Set<Team> teams;

    public Group(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getTeams() {
        return teams;
    }

    public void setTeams(Set teams) {
        this.teams = teams;
    }

    public void addTeams(Team team) {
        this.teams.add(team);
    }
}