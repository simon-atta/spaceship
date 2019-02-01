package com.spaceship.model.vo.board;

import java.util.List;

import com.spaceship.model.vo.shot.SalvoShotResponse;

public class SpaceshipSalvoShotsResponse {

    private List<SalvoShotResponse> salvoShots;
    private Boolean isAlive = true;

    /**
     * @return the salvoShots
     */
    public List<SalvoShotResponse> getSalvoShots() {
        return salvoShots;
    }

    /**
     * @param salvoShots
     *        the salvoShots to set
     */
    public void setSalvoShots(List<SalvoShotResponse> salvoShots) {
        this.salvoShots = salvoShots;
    }

    /**
     * @return the isAlive
     */
    public Boolean getIsAlive() {
        return isAlive;
    }

    /**
     * @param isAlive
     *        the isAlive to set
     */
    public void setIsAlive(Boolean isAlive) {
        this.isAlive = isAlive;
    }

}
