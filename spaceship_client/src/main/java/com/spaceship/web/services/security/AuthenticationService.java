package com.spaceship.web.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.spaceship.user.client.UserApiException;
import com.spaceship.user.client.model.PUser;
import com.spaceship.web.model.user.CurrentUser;
import com.spaceship.web.services.user.IUserService;

/**
 * This is service responsible for authenticate user.
 *
 * @author Simon Ghobreil
 */
@Component
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public CurrentUser loadUserByUsername(String userName) throws UsernameNotFoundException {

        try {
            PUser user = userService.getUserByUserName(userName);
            return new CurrentUser(user);
        } catch (UserApiException e) {
            e.printStackTrace();
            return null;
        }
    }

}
