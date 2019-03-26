package com.ivanleschinsky.football_match.repository;

import com.ivanleschinsky.football_match.domain.GroupTeam;
import org.springframework.data.repository.CrudRepository;

public interface GroupTeamRepository extends CrudRepository<GroupTeam, Integer> {
}
