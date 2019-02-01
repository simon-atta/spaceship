package com.spaceship.user.model.vo;

import java.util.Map;

public class SalvoShotResponse {

    private Map<String, String> salvo;
    private Map<String, String> game;

    public SalvoShotResponse() {
        super();
    }

    /**
     * @return the salvo
     */
    public Map<String, String> getSalvo() {
        return salvo;
    }

    /**
     * @param salvo
     *        the salvo to set
     */
    public void setSalvo(Map<String, String> salvo) {
        this.salvo = salvo;
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
