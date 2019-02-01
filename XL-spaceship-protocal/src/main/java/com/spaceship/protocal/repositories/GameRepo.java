package com.spaceship.protocal.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spaceship.protocal.model.entities.Game;

public interface GameRepo extends CrudRepository<Game, Long> {

    Game findByGameName(String gameName);



}
