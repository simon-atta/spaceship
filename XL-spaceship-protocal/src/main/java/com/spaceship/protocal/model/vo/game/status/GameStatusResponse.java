package com.spaceship.protocal.model.vo.game.status;

import java.util.Map;

public class GameStatusResponse {

    private GameStatusSpaceship self;
    private GameStatusSpaceship opponent;
    private Map<String, String> game;

    /**
     * @return the self
     */
    public GameStatusSpaceship getSelf() {
        return self;
    }

    /**
     * @param self
     *        the self to set
     */
    public void setSelf(GameStatusSpaceship self) {
        this.self = self;
    }

    /**
     * @return the opponent
     */
    public GameStatusSpaceship getOpponent() {
        return opponent;
    }

    /**
     * @param opponent
     *        the opponent to set
     */
    public void setOpponent(GameStatusSpaceship opponent) {
        this.opponent = opponent;
    }

    /**
     * @return the game
     */
    public Map<String, String> getGame() {
        return game;
    }

    /**
     * @param game
     *        the game to set
     */
    public void setGame(Map<String, String> game) {
        this.game = game;
    }

}
