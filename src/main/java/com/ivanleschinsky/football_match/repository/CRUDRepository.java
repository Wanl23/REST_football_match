package com.ivanleschinsky.football_match.repository;

import com.ivanleschinsky.football_match.MatchService;
import com.ivanleschinsky.football_match.domain.Game;
import com.ivanleschinsky.football_match.domain.Group;
import com.ivanleschinsky.football_match.domain.Team;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CRUDRepository {

    MatchService matchService = new MatchService();

    //Create
    public boolean createTeam(String name) {
        if (matchService.isTeamNameFree(name)) {
            Team team = new Team(name);
            matchService.getTeams().add(team);
            return true;
        } else {
            return false;
        }
    }

    public void createGroup(String name) {
        Group group = new Group(name);
        matchService.getGroups().add(group);
    }

    public void createGame(String team1, String team2, int goalsA, int goalsB) {
        Team a = getTeam(team1);
        Team b = getTeam(team2);
        if (!matchService.isTeamsInOneGroup(a, b)) {
            throw new IllegalArgumentException("teams in differets groups");
        }
        Game game = new Game(a, b, goalsA, goalsB);
        matchService.getGames().add(game);
    }

    public Team getTeam(String name) {
        return matchService.getTeams().stream().filter(t -> t.getName().equals(name)).findFirst().get();
    }

    public Group getGroup(String name) {
        return matchService.getGroups().stream().filter(g -> g.getName().equals(name)).findFirst().get();
    }

    public Game getGame(String team1, String team2) {
        Team a = getTeam(team1);
        Team b = getTeam(team2);
        return matchService.getGame(a, b);
    }

    //Get
    public List getTeams() {
        return matchService.getTeams();
    }

    public List getGroups() {
        return matchService.getGroups();
    }

    public List getGames() {
        return matchService.getGames();
    }

    //Update
    public void updateTeam(String name, String newName) {
        if (matchService.isTeamNameFree(newName)) {
            getTeam(name).setName(newName);
            return;
        }
        throw new IllegalArgumentException("team name is busy");
    }

    public void updateTeamData(String name, Integer wins, Integer loses, Integer draws) {
        getTeam(name).setWins(wins);
        getTeam(name).setLosses(loses);
        getTeam(name).setDraws(draws);
    }

    public void updateGroup(String name, String newTeam) {
        if (!matchService.isGroupFull(name)) {
            getGroup(name).addTeam(getTeam(newTeam));
            return;
        }
        throw new IllegalArgumentException("group is full");
    }

    public void updateGame(String team1, String team2, Integer goalsA, Integer goalsB) {
        Game game = getGame(team1, team2);
        game.setGoalsA(goalsA);
        game.setGoalsB(goalsB);
    }

    //Delete
    public void deleteTeam(String name) {
        getTeams().remove(getTeam(name));
    }

    public void deleteGroup(String name) {
        getGroups().remove(getGroup(name));
    }

    public void deleteGame(String team1, String team2) {
        getGames().remove(getGame(team1, team2));
    }
}
