package com.spaceship.user.model.vo;

import java.util.List;

import com.spaceship.client.model.InlineResponse2001;
import com.spaceship.user.model.entities.User;

public class UserVo extends User {

    private List<InlineResponse2001> spaceShips;

    public List<InlineResponse2001> getSpaceShips() {
        return spaceShips;
    }

    public void setSpaceShips(List<InlineResponse2001> spaceShips) {
        this.spaceShips = spaceShips;
    }

}
