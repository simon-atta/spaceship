package com.spaceship.protocal.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_id")
    private Long playerId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "player_type")
    private String playerType;

    @Column(name = "autopilot")
    private Boolean autoPilot = false;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "spaceship_id")
    private SpaceShipProtocal spaceShipProtocal;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    /**
     * @return the autoPilot
     */
    public Boolean getAutoPilot() {
        return autoPilot;
    }

    /**
     * @param autoPilot
     *        the autoPilot to set
     */
    public void setAutoPilot(Boolean autoPilot) {
        this.autoPilot = autoPilot;
    }

    /**
     * @return the playerType
     */
    public String getPlayerType() {
        return playerType;
    }

    /**
     * @param playerType
     *        the playerType to set
     */
    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     *        the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName
     *        the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the spaceShipProtocal
     */
    public SpaceShipProtocal getSpaceShipProtocal() {
        return spaceShipProtocal;
    }

    /**
     * @param spaceShipProtocal
     *        the spaceShipProtocal to set
     */
    public void setSpaceShipProtocal(SpaceShipProtocal spaceShipProtocal) {
        this.spaceShipProtocal = spaceShipProtocal;
    }

    /**
     * @return the playerId
     */
    public Long getPlayerId() {
        return playerId;
    }

    /**
     * @param playerId
     *        the playerId to set
     */
    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    /**
     * @return the game
     */
    public Game getGame() {
        return game;
    }

    /**
     * @param game
     *        the game to set
     */
    public void setGame(Game game) {
        this.game = game;
    }

}