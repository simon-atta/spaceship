package com.spaceship.user.model.vo;

import java.util.List;

public class SalvoShotRequest {

    private List<String> salvo;

    public SalvoShotRequest() {
        super();
    }

    public SalvoShotRequest(List<String> salvo) {
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
