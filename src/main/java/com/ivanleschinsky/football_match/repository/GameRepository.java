package com.ivanleschinsky.football_match.repository;

import com.ivanleschinsky.football_match.domain.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Integer> {
}
