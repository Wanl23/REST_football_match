package com.ivanleschinsky.football_match.repository;

import com.ivanleschinsky.football_match.domain.Game;
import com.ivanleschinsky.football_match.domain.GroupTeam;
import com.ivanleschinsky.football_match.domain.Team;
import com.ivanleschinsky.football_match.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CRUDRepository {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private GroupTeamRepository groupTeamRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private MatchService matchService;

    //Create methods
    public Iterable<Team> createTeam(String name) {
        if (!matchService.checkTeamNameIfNameIsFree(name)) {
            throw new IllegalArgumentException("Team name is busy");
        }
        teamRepository.save(new Team(name));
        return teamRepository.findAll();
    }

    public Iterable<GroupTeam> createGroup(String name) {
        if (!matchService.checkIfGroupNameIfNameIsFree(name)) {
            throw new IllegalArgumentException("Group name is busy");
        }
        groupTeamRepository.save(new GroupTeam(name));
        return groupTeamRepository.findAll();
    }

    public Iterable<Game> createGame(String a, String b) {
        List<Team> teams = new ArrayList<>();
        teamRepository.findAll().iterator().forEachRemaining(teams::add);
        Team teamA = teams.stream().filter(t -> t.getName().equals(a)).findFirst().get();
        Team teamB = teams.stream().filter(t -> t.getName().equals(b)).findFirst().get();
        if (!matchService.checkIfTeamInOneGroup(teamA, teamB)) {
            throw new IllegalArgumentException("teams is not in one team");
        }
        Game game = new Game(a, b);
        matchService.updateScoreData(teamA, teamB, game);
        gameRepository.save(game);
        return gameRepository.findAll();
    }

    //Get methods
    public Iterable<Team> getTeams() {
        return teamRepository.findAll();
    }

    public Team getTeam( Integer id) {
        return teamRepository.findById(id).get();
    }

    public Iterable<GroupTeam> getGroups() {
        return groupTeamRepository.findAll();
    }

    public GroupTeam getGroup(Integer id) {
        return groupTeamRepository.findById(id).get();
    }

    public Iterable<Game> getGames() {
        return gameRepository.findAll();
    }

    public Game getGame(Integer id) {
        return gameRepository.findById(id).get();
    }

    //Update methods
    public Team updateTeam(Integer id, String name) {
        teamRepository.findById(id).get().setName(name);
        return teamRepository.findById(id).get();
    }

    public GroupTeam updateGroup(Integer id, String name) {
        groupTeamRepository.findById(id).get().setName(name);
        return groupTeamRepository.findById(id).get();
    }

    public GroupTeam addTeamInGroup(Integer teamId, Integer groupId) {
        GroupTeam group = groupTeamRepository.findById(groupId).get();
        Team team = teamRepository.findById(teamId).get();
        group.getGroupTeams().add(team);
        groupTeamRepository.save(group);
        return groupTeamRepository.findById(groupId).get();
    }


    //Delete methods
    public Iterable<Team> deleteTeam(Integer id) {
        teamRepository.deleteById(id);
        return teamRepository.findAll();
    }

    public Iterable<GroupTeam> deleteGroup(Integer id) {
        groupTeamRepository.deleteById(id);
        return groupTeamRepository.findAll();
    }

    public Iterable<Game> deleteGame(Integer id) {
        gameRepository.deleteById(id);
        return gameRepository.findAll();
    }
}
