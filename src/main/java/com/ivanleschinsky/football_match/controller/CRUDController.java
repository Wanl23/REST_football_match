package com.ivanleschinsky.football_match.controller;

import com.ivanleschinsky.football_match.domain.Game;
import com.ivanleschinsky.football_match.domain.Group;
import com.ivanleschinsky.football_match.domain.Team;
import com.ivanleschinsky.football_match.repository.CRUDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("crud")
public class CRUDController {

    @Autowired
    private CRUDRepository crudRepository;

    //Create methods
    @GetMapping("/create_team")
    public List<Team> createTeam(@RequestParam String name) {
        if (crudRepository.createTeam(name)) {
            return crudRepository.getTeams();
        }
        throw new IllegalArgumentException("Team name is busy");
    }

    @GetMapping("/create_group")
    public List<Group> createGroup(@RequestParam String name) {
        crudRepository.createGroup(name);
        return crudRepository.getGroups();
    }

    @GetMapping("/create_game")
    public List<Game> createGame(@RequestParam String teamA,
                                 @RequestParam String teamB,
                                 @RequestParam Integer goalsA,
                                 @RequestParam Integer goalsB) {
        crudRepository.createGame(teamA, teamB, goalsA, goalsB);
        return crudRepository.getGames();
    }

    //Get methods
    @GetMapping("/get_teams")
    public List<Team> getTeams() {
        return crudRepository.getTeams();
    }

    @GetMapping("/get_groups")
    public List<Group> getGroups() {
        return crudRepository.getGroups();
    }

    @GetMapping("/get_games")
    public List<Game> getGames() {
        return crudRepository.getGames();
    }

    //Update methods
    @GetMapping("/update_team")
    public Team updateTeam(@RequestParam String name,
                           @RequestParam String newName) {
        if (crudRepository.updateTeam(name, newName)) {
            return crudRepository.getTeam(newName);
        }
        throw new IllegalArgumentException("Team name is busy");
    }

    @GetMapping("/update_group")
    public Group updateGroup(@RequestParam String name,
                             @RequestParam(required = false) String team) {
        if (crudRepository.updateGroup(name, team)) {
            return crudRepository.getGroup(name);
        }
        throw new IllegalArgumentException("group is full");
    }

    @GetMapping("/update_game")
    public Game updateGame(@RequestParam String teamA,
                           @RequestParam String teamB,
                           @RequestParam Integer goalsA,
                           @RequestParam Integer goalsB) {
        crudRepository.updateGame(teamA, teamB, goalsA, goalsB);
        return crudRepository.getGame(teamA, teamB);
    }

    //Delete methods

    @GetMapping("/delete_team")
    public List<Team> deleteTeam(@RequestParam String name) {
        crudRepository.deleteTeam(name);
        return crudRepository.getTeams();
    }

    @GetMapping("/delete_group")
    public List<Group> deleteGroup(@RequestParam String name) {
        crudRepository.deleteGroup(name);
        return crudRepository.getGroups();
    }

    @GetMapping("/delete_game")
    public List<Game> deleteGame(@RequestParam String teamA,
                                 @RequestParam String teamB) {
        crudRepository.deleteGame(teamA, teamB);
        return crudRepository.getGames();
    }
}
