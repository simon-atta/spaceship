package com.spaceship.user.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spaceship.user.model.entities.User;

public interface UserRepo extends CrudRepository<User, Long> {


    User findByUserId(String userId);

}
