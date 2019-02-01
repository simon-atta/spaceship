package com.spaceship.web.services.user;

import java.util.List;

import com.spaceship.user.client.UserApiException;
import com.spaceship.user.client.model.InlineResponse2001;
import com.spaceship.user.client.model.PUser;
import com.spaceship.web.model.vo.User;

public interface IUserService {

    void createUser(User user) throws UserApiException;

    List<InlineResponse2001> getUserList() throws UserApiException;

    PUser getUserByUserName(String userName) throws UserApiException;

}
