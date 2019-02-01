package com.spaceship.protocal.model.vo.game.fire;

import java.util.List;

public class SalvoShotRequest {

    private List<String> salvo;

    public SalvoShotRequest() {
        super();
    }

    public SalvoShotRequest(List<String> salvo, String gameId) {
        super();
        this.salvo = salvo;
    }


    /**
     * @return the salvo
     */
    public List<String> getSalvo() {
        return salvo;
    }

    /**
     * @param salvo
     *        the salvo to set
     */
    public void setSalvo(List<String> salvo) {
        this.salvo = salvo;
    }


}
