package com.ivanleschinsky.football_match.repository;

import com.ivanleschinsky.football_match.domain.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Integer> {
}
