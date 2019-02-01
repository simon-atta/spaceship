package com.spaceship.web.model.game;

import java.util.ArrayList;
import java.util.List;

public class SalvoShots {

    private List<String> salvoShotsList;

    public SalvoShots() {
        salvoShotsList = new ArrayList<>();
    }

    public SalvoShots(List<String> salvoShots) {
        this.salvoShotsList = salvoShots;
    }

    /**
     * @return the salvoShotsList
     */
    public List<String> getSalvoShotsList() {
        return salvoShotsList;
    }

    /**
     * @param salvoShotsList the salvoShotsList to set
     */
    public void setSalvoShotsList(List<String> salvoShotsList) {
        this.salvoShotsList = salvoShotsList;
    }


}
