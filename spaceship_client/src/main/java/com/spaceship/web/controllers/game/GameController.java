package com.spaceship.web.controllers.game;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spaceship.user.client.UserApiException;
import com.spaceship.user.client.model.SalvoShot;
import com.spaceship.web.controllers.AbstractController;
import com.spaceship.web.model.constacts.ViewConstants;
import com.spaceship.web.model.game.SalvoShots;
import com.spaceship.web.services.game.IGameService;

@Controller
@RequestMapping("/game")
public class GameController extends AbstractController {

    private static final Logger LOGGER = Logger.getLogger(GameController.class);

    @Autowired
    private IGameService gameService;

    @GetMapping("/list")
    public String getAllGamesByUserName(Model model) {
        try {
            model.addAttribute(ViewConstants.GAME_LIST.toString(), gameService.getAllGamesByUserId(getUserName()));
            model.addAttribute(ViewConstants.USER_PARAM.toString(), getUserName());
            return ViewConstants.GAME_LIST_VIEW.toString();
        } catch (com.spaceship.protocal.client.ProtocalApiException exception) {
            LOGGER.error(ViewConstants.EXCEPTION_MESSAGE.toString(), exception);
            model.addAttribute(ViewConstants.ERROR.toString(), getErrorCode(ViewConstants.ERROR_CODE.toString(), exception.getCode()));
            return "";
        }
    }

    @GetMapping("/status/{gameId}")
    public String getStatus(Model model, @PathVariable("gameId") String gameId) {
        try {
            model.addAttribute(ViewConstants.GAME_STATUS.toString(), gameService.getGameStatus(gameId));
            model.addAttribute(ViewConstants.GAME_AUTO_STATUS.toString(), gameService.getAutoPilotStatus(gameId, getUserName()));
            model.addAttribute(ViewConstants.GAME_STATUS_SELF.toString(), getBoardAsArray(gameService.getGameStatus(gameId).getSelf().getBoard()));
            model.addAttribute(ViewConstants.GAME_STATUS_OPP.toString(), getBoardAsArray(gameService.getGameStatus(gameId).getOpponent().getBoard()));
            model.addAttribute(ViewConstants.GAME_ID.toString(), gameId);
            model.addAttribute(ViewConstants.USER_PARAM.toString(), getUserName());
            return ViewConstants.GAME_STATUS_VIEW.toString();
        } catch (com.spaceship.protocal.client.ProtocalApiException exception) {
            LOGGER.error(ViewConstants.EXCEPTION_MESSAGE.toString(), exception);
            model.addAttribute(ViewConstants.ERROR.toString(), getErrorCode(ViewConstants.ERROR_CODE.toString(), exception.getCode()));
            return "";
        }
    }

    @GetMapping("/fire/{gameId}")
    public String fireView(Model model, @PathVariable("gameId") String gameId) {
        try {
            Integer size = gameService.getSalvoShotsNumber(gameId);
            model.addAttribute("gameId", gameId);
            model.addAttribute(ViewConstants.GAME_FIRE.toString(), size);
            model.addAttribute(ViewConstants.GAME_SALVOSHOTS.toString(), new SalvoShots(getList(size)));
            return ViewConstants.GAME_FIRE_VIEW.toString();
        } catch (com.spaceship.protocal.client.ProtocalApiException exception) {
            LOGGER.error(ViewConstants.EXCEPTION_MESSAGE.toString(), exception);
            model.addAttribute(ViewConstants.ERROR.toString(), getErrorCode(ViewConstants.ERROR_CODE.toString(), exception.getCode()));
            return "redirect:/game/list/";
        }
    }

    @GetMapping("/fireerror/{gameId}/{error}")
    public String fireErrorView(Model model, @PathVariable("gameId") String gameId, @PathVariable("error") String error) {
        try {
            Integer size = gameService.getSalvoShotsNumber(gameId);
            model.addAttribute("gameId", gameId);
            model.addAttribute(ViewConstants.GAME_FIRE.toString(), size);
            model.addAttribute(ViewConstants.GAME_SALVOSHOTS.toString(), new SalvoShots(getList(size)));
            model.addAttribute(ViewConstants.ERROR.toString(), "fire." + error);
            return ViewConstants.GAME_FIRE_VIEW.toString();
        } catch (com.spaceship.protocal.client.ProtocalApiException exception) {
            LOGGER.error(ViewConstants.EXCEPTION_MESSAGE.toString(), exception);
            model.addAttribute(ViewConstants.ERROR.toString(), getErrorCode(ViewConstants.ERROR_CODE.toString(), exception.getCode()));
            return "redirect:/game/status/" + gameId;
        }
    }

    private List<String> getList(Integer count) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add("");
        }
        return list;
    }

    @PostMapping("/fire/{gameId}")
    public String fire(Model model, @ModelAttribute SalvoShots salvoShots, @PathVariable("gameId") String gameId) {
        try {
            SalvoShot salvoShot = new SalvoShot();
            salvoShot.setSalvo(salvoShots.getSalvoShotsList());
            model.addAttribute(ViewConstants.GAME_FIRE_RESULTS.toString(), gameService.fireSalvoShots(gameId, salvoShot));
            return ViewConstants.GAME_FIRE_RESULTS_VIEW.toString();
        } catch (UserApiException exception) {
            LOGGER.error(ViewConstants.EXCEPTION_MESSAGE.toString(), exception);
            model.addAttribute(ViewConstants.ERROR.toString(), "fire." + exception.getCode());
            return "redirect:/game/fireerror/" + gameId + "/" + exception.getCode();
        }
    }

}
