package com.spaceship.protocal.model.vo.game.create;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpaceShipProtocalRequest {

    private String hostName;
    private String port;

    /**
     * @return the hostName
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * @param hostName
     *        the hostName to set
     */
    @JsonProperty("hostname")
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port
     *        the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }

}
