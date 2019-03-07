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
import java.util.Optional;

@RestController
@RequestMapping("crud")
public class CRUDController {

    @Autowired
    private CRUDRepository crudRepository;

    @GetMapping("/init for tests")
    public void generate() {
        crudRepository.createTeam("team1");
        crudRepository.createTeam("team2");
        crudRepository.createTeam("team3");
        crudRepository.createTeam("team4");
        crudRepository.createTeam("team5");

        crudRepository.updateTeamData("team1", 10, 2, 1);
        crudRepository.updateTeamData("team2", 20, 2, 2);
        crudRepository.updateTeamData("team3", 30, 2, 3);
        crudRepository.updateTeamData("team4", 40, 2, 4);
        crudRepository.updateTeamData("team5", 50, 2, 5);

        crudRepository.createGroup("a");
        crudRepository.createGroup("b");
        crudRepository.createGroup("c");
        crudRepository.createGroup("d");
        crudRepository.createGroup("e");
        crudRepository.createGroup("f");

        crudRepository.updateGroup("a", "team1");
        crudRepository.updateGroup("a", "team2");
        crudRepository.updateGroup("a", "team3");
        crudRepository.updateGroup("b", "team4");
        crudRepository.updateGroup("b", "team5");
    }

    //Create methods
    @GetMapping("/create_team")
    public List<Team> createTeam(@RequestParam String name) {
        crudRepository.createTeam(name);
        return crudRepository.getTeams();
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

    @GetMapping("/get_group_info")
    public List<Group> getGroupInfo(@RequestParam String name) {
        return crudRepository.getGroupInfo(name);
    }

    //Update methods
    @GetMapping("/update_team")
    public Team updateTeam(@RequestParam String name,
                           @RequestParam(required = false) String newName,
                           @RequestParam Integer wins,
                           @RequestParam Integer loses,
                           @RequestParam Integer draws) {
        if (newName != null && !name.equals(newName)) {
            crudRepository.updateTeam(name, newName);
            name = newName;
        }
        crudRepository.updateTeamData(name, wins, loses, draws);
        return crudRepository.getTeam(name);
    }

    @GetMapping("/update_group")
    public Group updateGroup(@RequestParam(value = "group_name") String name,
                             @RequestParam String team) {
        crudRepository.updateGroup(name, team);
        return crudRepository.getGroup(name);


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
