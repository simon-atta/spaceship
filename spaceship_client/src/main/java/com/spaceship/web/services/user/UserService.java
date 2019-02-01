package com.spaceship.web.services.user;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spaceship.user.client.UserApiException;
import com.spaceship.user.client.api.UserresourceApi;
import com.spaceship.user.client.model.InlineResponse2001;
import com.spaceship.user.client.model.PUser;
import com.spaceship.web.model.vo.User;


@Service
public class UserService implements IUserService {

    private UserresourceApi userResourceApi = new UserresourceApi();

    @Override
    public void createUser(User user) throws UserApiException {
        PUser vUser = new PUser();
        vUser.setFullName(user.getFullName());
        vUser.userId(user.getUserName());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        vUser.setPassword(hashedPassword);

        userResourceApi.createUserUsingPOST(vUser);
    }

    @Override
    public List<InlineResponse2001> getUserList() throws UserApiException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userId = auth.getName();

        return userResourceApi.getAllOpponentUsersUsingGET(userId);

    }

    @Override
    public PUser getUserByUserName(String userName) throws UserApiException {
        return userResourceApi.getUserByUserNameUsingGET(userName);
    }

}
