package com.spaceship.user.services;

import java.util.List;

import com.spaceship.client.ApiException;
import com.spaceship.user.model.entities.User;
import com.spaceship.user.model.vo.UserVo;


public interface IUserService {

    void createUser(User pUser);

    List<UserVo> getAllUsers() throws ApiException;

    List<UserVo> getAllOpponentUsers(String userId) throws ApiException;

    User getUserByUserName(String userId);



}
