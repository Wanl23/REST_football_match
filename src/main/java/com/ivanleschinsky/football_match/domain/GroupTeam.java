package com.ivanleschinsky.football_match.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class GroupTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "group_teams", joinColumns = @JoinColumn(name = "id"))
    private Set<Team> groupTeams;

    public GroupTeam(String name) {
        this.name = name;
        this.groupTeams = new HashSet<>();
    }

    public GroupTeam() {
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

    public Set<Team> getGroupTeams() {
        return groupTeams;
    }

    public void setGroupTeams(Set<Team> groupTeams) {
        this.groupTeams = groupTeams;
    }
}
