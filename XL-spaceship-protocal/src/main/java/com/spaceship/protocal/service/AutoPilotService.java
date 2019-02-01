package com.spaceship.protocal.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.spaceship.protocal.model.entities.Game;
import com.spaceship.protocal.model.entities.Player;
import com.spaceship.protocal.repositories.PlayerRepo;
import com.spaceship.user.client.api.GameresourceApi;

@Component
public class AutoPilotService {


    private static final Logger LOGGER = Logger.getLogger(AutoPilotService.class);

    @Autowired
    private PlayerRepo playerRepo;

    @Async
    public void fireAutoPoilte(Game game, Player player) {
        try {
            GameresourceApi gameResourceApi = new GameresourceApi();
            gameResourceApi.fireAutoPilotSalvoShotsUsingPOST(game.getGameName());
        } catch (com.spaceship.user.client.UserApiException e) {
            player.setAutoPilot(false);
            playerRepo.save(player);
            LOGGER.error("Something went wrong!", e);
        }
    }

}
