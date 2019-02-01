package com.spaceship.protocal.model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Game Entity.
 *
 * @author Simon Ghobreil.
 */
@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "game_name", unique = true)
    private String gameName;

    @Column(name = "player_turn")
    private String playerTurn;

    @Column(name = "winner")
    private String winner;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<Player> players;

    @Column(name = "status")
    private String gameStatus;



    /**
     * @return the winner
     */
    public String getWinner() {
        return winner;
    }

    /**
     * @param winner the winner to set
     */
    public void setWinner(String winner) {
        this.winner = winner;
    }

    /**
     * @return the gameStatus
     */
    public String getGameStatus() {
        return gameStatus;
    }

    /**
     * @param gameStatus
     *        the gameStatus to set
     */
    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }

    /**
     * @return the gameId
     */
    public Long getGameId() {
        return gameId;
    }

    /**
     * @param gameId
     *        the gameId to set
     */
    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    /**
     * @return the gameName
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * @param gameName
     *        the gameName to set
     */
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    /**
     * @return the playerTurn
     */
    public String getPlayerTurn() {
        return playerTurn;
    }

    /**
     * @param playerTurn
     *        the playerTurn to set
     */
    public void setPlayerTurn(String playerTurn) {
        this.playerTurn = playerTurn;
    }

    /**
     * @return the players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * @param players
     *        the players to set
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

}
