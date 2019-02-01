package com.spaceship.web.controllers.game;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spaceship.protocal.client.ProtocalApiException;
import com.spaceship.web.controllers.AbstractController;
import com.spaceship.web.model.game.AutoPilot;
import com.spaceship.web.services.game.IGameService;

@RestController
@RequestMapping("/game")
public class AutoPilotController extends AbstractController {

    private static final Logger LOGGER = Logger.getLogger(AutoPilotController.class);

    @Autowired
    private IGameService gameService;

    @PostMapping("/setautopilot")
    public String enableDisableAutoPilot(Model model, @RequestBody AutoPilot autoPilot) {
    	LOGGER.info("AutoPilotController - enableDisableAutoPilot : started");
        try {
            gameService.enableDiableAutoPilot(autoPilot.getValue(), autoPilot.getGameId(), getUserName());
        } catch (ProtocalApiException e) {
            e.printStackTrace();
        }

        return autoPilot.getValue();
    }



}
