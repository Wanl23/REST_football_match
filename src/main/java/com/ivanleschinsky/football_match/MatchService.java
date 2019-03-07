package com.ivanleschinsky.football_match;

import com.ivanleschinsky.football_match.domain.Game;
import com.ivanleschinsky.football_match.domain.Group;
import com.ivanleschinsky.football_match.domain.Team;
import java.util.ArrayList;
import java.util.List;

public class MatchService {

    private List<Team> teams = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();
    private List<Game> games = new ArrayList<>();

    public boolean isTeamsInOneGroup(Team a, Team b) {
        return getGroups().stream().anyMatch(g -> g.getTeams().contains(a) && g.getTeams().contains(b));
    }

    public boolean isTeamNameFree(String name) {
        return !getTeams().stream().anyMatch(t -> t.getName().equals(name));
    }

    public boolean isGroupNameFree(String name) {
        return !getGroups().stream().anyMatch(t -> t.getName().equals(name));
    }

    public boolean isGroupFull(String name) {
        return groups.size() > 3;
    }

    public Game getGame(Team a, Team b) {
        return games.stream().filter(g -> g.getA() == a && g.getB() == b || g.getA() == b && g.getB() == a).findAny().get();
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

}
