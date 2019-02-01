package com.spaceship.protocal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spaceship.protocal.model.entities.Game;
import com.spaceship.protocal.model.entities.Player;
import com.spaceship.protocal.model.entities.SpaceShipProtocal;
import com.spaceship.protocal.model.vo.game.GameStatusType;
import com.spaceship.protocal.model.vo.game.create.GameRequest;
import com.spaceship.protocal.model.vo.game.create.PlayerRequest;
import com.spaceship.protocal.model.vo.game.create.SpaceShipProtocalRequest;
import com.spaceship.protocal.repositories.GameRepo;
import com.spaceship.protocal.repositories.PlayerRepo;

@Service
public class GameServiceRepo {

    @Autowired
    private GameRepo gameRepo;

    @Autowired
    private PlayerRepo playerRepo;

    public List<Game> getGameListByUserId(String userId) {
        List<Game> gameList = new ArrayList<>();
        List<Player> players = (List<Player>) playerRepo.findAll();
        for (Player player : players) {
            if (player.getUserId().equals(userId)) {
                gameList.add(player.getGame());
            }
        }
        return gameList;

    }

    public Game createNewGame(GameRequest pGameRequest) {
        Game vGame = new Game();
        vGame.setGameName(getGameName());
        vGame.setGameStatus(GameStatusType.CREATED.toString());
        gameRepo.save(vGame);

        vGame.setPlayers(getPlayerList(pGameRequest, vGame));
        vGame.setPlayerTurn(getPlayerTurn(vGame.getPlayers()));
        gameRepo.save(vGame);
        return vGame;
    }

    private String getPlayerTurn(List<Player> players) {
        Random randomizer = new Random();
        Player random = players.get(randomizer.nextInt(players.size()));
        return random.getUserId();
    }

    private String getGameName() {
        StringBuilder vGameName = new StringBuilder();
        vGameName.append("match-");
        vGameName.append(gameRepo.count() + 1);
        return vGameName.toString();
    }

    private List<Player> getPlayerList(GameRequest pGameRequest, Game pGame) {
        List<Player> vPlayers = new ArrayList<>();

        for (PlayerRequest playerRequest : pGameRequest.getPlayers()) {
            vPlayers.add(getPlayer(playerRequest, pGame));
        }

        return vPlayers;
    }

    private Player getPlayer(PlayerRequest playerRequest, Game pGame) {
        Player player = new Player();
        player.setFullName(playerRequest.getFullName());
        player.setPlayerType(playerRequest.getPlayerType().toString());
        player.setSpaceShipProtocal(getSpaceShipProtocal(playerRequest.getSpaceShipProtocal()));
        player.setUserId(playerRequest.getUserId());
        player.setGame(pGame);
        return player;
    }

    private SpaceShipProtocal getSpaceShipProtocal(SpaceShipProtocalRequest spaceShipProtocalRequest) {
        SpaceShipProtocal spaceShipProtocal = new SpaceShipProtocal();
        spaceShipProtocal.setHostName(spaceShipProtocalRequest.getHostName());
        spaceShipProtocal.setPort(spaceShipProtocalRequest.getPort());
        return spaceShipProtocal;
    }

}
