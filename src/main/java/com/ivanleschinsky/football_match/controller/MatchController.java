package com.ivanleschinsky.football_match.controller;

import com.ivanleschinsky.football_match.domain.Game;
import com.ivanleschinsky.football_match.domain.GroupTeam;
import com.ivanleschinsky.football_match.domain.Team;
import com.ivanleschinsky.football_match.repository.CRUDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/crud")
public class MatchController {

    @Autowired
    private CRUDRepository crudRepository;

    @GetMapping(path = "/init")
    public @ResponseBody String init() {
        crudRepository.createTeam("team1");
        crudRepository.createTeam("team2");
        crudRepository.createTeam("team3");
        crudRepository.createTeam("team4");
        crudRepository.createTeam("team5");
        crudRepository.createGroup("a");
        crudRepository.createGroup("b");
        crudRepository.createGroup("c");
        crudRepository.createGroup("d");
        crudRepository.createGroup("e");
        return "OK";
    }

    //Create methods
    @GetMapping(path = "/create_team")
    public @ResponseBody Iterable<Team> createTeam(@RequestParam String name) {
        return crudRepository.createTeam(name);
    }

    @GetMapping(path = "/create_group")
    public @ResponseBody Iterable<GroupTeam> createGroup(@RequestParam String name) {
        return crudRepository.createGroup(name);
    }

    @GetMapping(path = "/create_game")
    public @ResponseBody Iterable<Game> createGame(@RequestParam String team_a, @RequestParam String team_b) {
        return crudRepository.createGame(team_a, team_b);
    }

    //Get methods
    @GetMapping(path = "/get_teams")
    public @ResponseBody Iterable<Team> getTeams() {
        return crudRepository.getTeams();
    }

    @GetMapping(path = "/get_team")
    public @ResponseBody Team getTeam(@RequestParam Integer id) {
        return crudRepository.getTeam(id);
    }

    @GetMapping(path = "/get_groups")
    public @ResponseBody Iterable<GroupTeam> getGroups() {
        return crudRepository.getGroups();
    }

    @GetMapping(path = "/get_group")
    public @ResponseBody GroupTeam getGroup(@RequestParam Integer id) {
        return crudRepository.getGroup(id);
    }

    @GetMapping(path = "/get_games")
    public @ResponseBody Iterable<Game> getGames() {
        return crudRepository.getGames();
    }

    @GetMapping(path = "/get_game")
    public @ResponseBody Game getGame(@RequestParam Integer id) {
        return crudRepository.getGame(id);
    }

    @GetMapping(path = "/get_group_info")
    public @ResponseBody List<Team> getGroupeInfo(@RequestParam Integer id) {
        return crudRepository.getGroupInfo(id);
    }

    //Update methods
    @GetMapping(path = "/update_team")
    public @ResponseBody Team updateTeam(@RequestParam Integer id, @RequestParam String name) {
        return crudRepository.updateTeam(id, name);
    }

    @GetMapping(path = "/update_group")
    public @ResponseBody GroupTeam updateGroup(@RequestParam Integer id, @RequestParam String name) {
        return crudRepository.updateGroup(id, name);
    }

    @GetMapping(path = "/add_team_in_group")
    public @ResponseBody GroupTeam addTeamInGroup(@RequestParam Integer teamId, @RequestParam Integer groupId) {
        return crudRepository.addTeamInGroup(teamId, groupId);
    }

//  If you need to update game, create method here
//    @GetMapping(path = "/update_game")
//    public @ResponseBody Team updateGame(@RequestParam Integer id) {
//    }


    //Delete methods
    @GetMapping(path = "/delete_team")
    public @ResponseBody Iterable<Team> deleteTeam(@RequestParam Integer id) {
        return crudRepository.deleteTeam(id);
    }

    @GetMapping(path = "/delete_group")
    public @ResponseBody Iterable<GroupTeam> deleteGroup(@RequestParam Integer id) {
        return crudRepository.deleteGroup(id);
    }

    @GetMapping(path = "/delete_game")
    public @ResponseBody Iterable<Game> deleteGame(@RequestParam Integer id) {
        return crudRepository.deleteGame(id);
    }

}
