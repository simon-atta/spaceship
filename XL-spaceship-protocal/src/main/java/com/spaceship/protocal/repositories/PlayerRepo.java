package com.spaceship.protocal.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spaceship.protocal.model.entities.Player;

public interface PlayerRepo extends CrudRepository<Player, Long> {



}
