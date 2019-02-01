package com.spaceship.model.vo.shot;

public class SalvoShotRequest {

    private String[] salvo;
    private String gameId;

    public SalvoShotRequest() {
        super();
    }

    public SalvoShotRequest(String[] salvo, String gameId) {
        super();
        this.salvo = salvo;
        this.gameId = gameId;
    }

    /**
     * @return the salvo
     */
    public String[] getSalvo() {
        return salvo;
    }

    /**
     * @param salvo
     *        the salvo to set
     */
    public void setSalvo(String[] salvo) {
        this.salvo = salvo;
    }

    /**
     * @return the gameId
     */
    public String getGameId() {
        return gameId;
    }

    /**
     * @param gameId
     *        the gameId to set
     */
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

}
