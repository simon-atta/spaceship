package com.spaceship.user.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spaceship.client.ApiException;
import com.spaceship.client.api.XlspaceshipresourceApi;
import com.spaceship.user.model.entities.User;
import com.spaceship.user.model.vo.UserVo;
import com.spaceship.user.repositories.UserRepo;


@Component
public class UserService implements IUserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class);

    @Autowired
    private UserRepo userRepo;

    private final XlspaceshipresourceApi spaceshipResourceApi = new XlspaceshipresourceApi();

    @Override
    @Transactional
    public void createUser(User pUser) {
        userRepo.save(pUser);
    }

    @Override
    public List<UserVo> getAllUsers() throws ApiException {
    	
    	LOGGER.info("UserService - getAllUsers : started");

        List<UserVo> userList = new ArrayList<>();

        for (User user : userRepo.findAll()) {
            getUserVo(userList, user);
        }
        return userList;
    }

    private void getUserVo(List<UserVo> userList, User user) throws ApiException {
        UserVo userVo = new UserVo();
        userVo.setFullName(user.getFullName());
        userVo.setId(user.getId());
        userVo.setUserId(user.getUserId());
        userVo.setSpaceShips(spaceshipResourceApi.getSpaceshipsByUserIdUsingGET(user.getUserId()));
        userList.add(userVo);
    }

    @Override
    public User getUserByUserName(String userId) {
        return userRepo.findByUserId(userId);
    }

    @Override
    public List<UserVo> getAllOpponentUsers(String userName) throws ApiException {
        List<UserVo> userList = new ArrayList<>();
        for (User user : userRepo.findAll()) {
            if (!user.getUserId().equals(userName)) {
                getUserVo(userList, user);
            }
        }
        return userList;
    }



}
