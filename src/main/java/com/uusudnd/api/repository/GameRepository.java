package com.uusudnd.api.repository;

import com.uusudnd.api.entity.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {
}
