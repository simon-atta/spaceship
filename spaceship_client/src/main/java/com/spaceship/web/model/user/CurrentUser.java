package com.spaceship.web.model.user;

import org.springframework.security.core.authority.AuthorityUtils;

import com.spaceship.user.client.model.PUser;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private static final long serialVersionUID = 1L;
    private PUser user;

    public CurrentUser(PUser user) {
        super(user.getUserId(), user.getPassword(), true, true, true, true, AuthorityUtils.createAuthorityList("USER"));
        this.user = user;
    }

    public Long getId() {
        return user.getId();
    }

    public PUser getUser() {
        return user;
    }

    public void setUser(PUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CurrentUser{" + "user=" + user + "} " + super.toString();
    }
}
