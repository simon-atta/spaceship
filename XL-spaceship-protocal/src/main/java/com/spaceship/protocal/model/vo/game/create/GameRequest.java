package com.spaceship.protocal.model.vo.game.create;

import java.util.List;

public class GameRequest {

    private List<PlayerRequest> players;

    /**
     * @return the players
     */
    public List<PlayerRequest> getPlayers() {
        return players;
    }

    /**
     * @param players
     *        the players to set
     */
    public void setPlayers(List<PlayerRequest> players) {
        this.players = players;
    }

}
