package com.ivanleschinsky.football_match.service;

import com.ivanleschinsky.football_match.domain.Game;
import com.ivanleschinsky.football_match.domain.GroupTeam;
import com.ivanleschinsky.football_match.domain.Team;
import com.ivanleschinsky.football_match.repository.GameRepository;
import com.ivanleschinsky.football_match.repository.GroupTeamRepository;
import com.ivanleschinsky.football_match.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class MatchService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GroupTeamRepository groupTeamRepository;

    public void updateScoreData(Team teamA, Team teamB, Game game) {
        if (game.getGoalsA() > game.getGoalsB()) {
            teamA.setWins(teamA.getWins() + 1);
            teamB.setLosses(teamB.getLosses() + 1);
        } else if (game.getGoalsA() < game.getGoalsB()) {
            teamA.setWins(teamA.getWins() + 1);
            teamB.setLosses(teamB.getLosses() + 1);
        } else {
            teamA.setDraws(teamA.getDraws() + 1);
            teamB.setDraws(teamB.getDraws() + 1);
        }
        teamRepository.save(teamA);
        teamRepository.save(teamB);
    }

    public boolean checkIfTeamInOneGroup(Team a, Team b) {
        List<GroupTeam> groups = new ArrayList<>();
        groupTeamRepository.findAll().iterator().forEachRemaining(groups::add);
        if (groups.stream().anyMatch(g -> g.getGroupTeams().contains(a) && g.getGroupTeams().contains(b))) {
            return true;
        }
        return false;
    }

    public boolean checkTeamNameIfNameIsFree(String name) {
        List<Team> teams = new ArrayList<>();
        teamRepository.findAll().iterator().forEachRemaining(teams::add);
        if (teams.stream().anyMatch(t -> t.getName().equals(name))) {
            return false;
        }
        return true;
    }

    public boolean checkIfGroupNameIfNameIsFree(String name) {
        List<GroupTeam> groups = new ArrayList<>();
        groupTeamRepository.findAll().iterator().forEachRemaining(groups::add);
        if (groups.stream().anyMatch(g -> g.getName().equals(name))) {
            return false;
        }
        return true;
    }
}
