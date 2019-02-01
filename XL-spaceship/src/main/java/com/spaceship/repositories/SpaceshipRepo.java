package com.spaceship.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spaceship.model.entities.Spaceship;

public interface SpaceshipRepo extends CrudRepository<Spaceship, Long> {

	@Override
    List<Spaceship> findAll();

	List<Spaceship> findByUserId(String userId);

	Spaceship findBySpaceshipId(Long spaceshipId);

}
