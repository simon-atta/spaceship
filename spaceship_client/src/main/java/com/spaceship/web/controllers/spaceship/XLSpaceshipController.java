package com.spaceship.web.controllers.spaceship;

import java.util.ArrayList;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spaceship.client.ApiException;
import com.spaceship.client.model.InlineResponse2001;
import com.spaceship.client.model.SpaceshipRequest;
import com.spaceship.web.controllers.AbstractController;
import com.spaceship.web.model.constacts.ViewConstants;
import com.spaceship.web.model.spaceship.SpaceshipBoard;
import com.spaceship.web.services.game.IGameService;
import com.spaceship.web.services.spaceships.ISpaceshipService;

@Controller
public class XLSpaceshipController extends AbstractController {

    private static final Logger LOGGER = Logger.getLogger(XLSpaceshipController.class);

    @Autowired
    private ISpaceshipService spaceshipService;

    @Autowired
    private IGameService gameService;

    @GetMapping("/getspaceships/{user}")
    public String getSpaceShipsByUserId(Model model, @PathVariable("user") String userName) {
        try {
            model.addAttribute(ViewConstants.USER_PARAM.toString(), userName);
            model.addAttribute(ViewConstants.SPACESHIPS_PARAM.toString(), spaceshipService.getSpaceshipsByUserName(userName));
            return ViewConstants.XLSPACESHIP_LIST_ALL.toString();
        } catch (ApiException exception) {
            LOGGER.error(ViewConstants.EXCEPTION_MESSAGE.toString(), exception);
            model.addAttribute(ViewConstants.ERROR.toString(), getErrorCode(ViewConstants.ERROR_CODE.toString(), exception.getCode()));
            return ViewConstants.XLSPACESHIP_LIST_ALL.toString();
        }
    }

    @GetMapping("/getuserspaceships/{user}")
    public String getUserXLSpaceships(Model model, @PathVariable("user") String userName) {
        try {
            model.addAttribute(ViewConstants.SPACESHIPS_PARAM.toString(), spaceshipService.getSpaceshipsByUserName(userName));
            return ViewConstants.XLSPACESHIP_USER_LIST.toString();
        } catch (ApiException exception) {
            LOGGER.error(ViewConstants.EXCEPTION_MESSAGE.toString(), exception);
            model.addAttribute(ViewConstants.ERROR.toString(), getErrorCode(ViewConstants.ERROR_CODE.toString(), exception.getCode()));
            return ViewConstants.XLSPACESHIP_LIST_ALL.toString();
        }
    }

    @GetMapping("/getallspaceships")
    public String getAllSpaceships(Model model) {
        try {
            model.addAttribute(ViewConstants.SPACESHIPS_PARAM.toString(), spaceshipService.getAllSpaceships());
            return ViewConstants.XLSPACESHIP_ASSIGN.toString();
        } catch (ApiException exception) {
            LOGGER.error(ViewConstants.EXCEPTION_MESSAGE.toString(), exception);
            model.addAttribute(ViewConstants.ERROR.toString(), getErrorCode(ViewConstants.ERROR_CODE.toString(), exception.getCode()));
            model.addAttribute(ViewConstants.SPACESHIPS_PARAM.toString(), null);
            return ViewConstants.XLSPACESHIP_LIST_ALL.toString();
        }
    }

    @GetMapping("/assignspaceship/{id}")
    public String assignXLSpaceShipToUser(Model model, @PathVariable("id") String spaceshipId) {
        try {

        	spaceshipService.assignXLSpaceshipToUser(spaceshipId, getUserName());
            InlineResponse2001 spaceship = spaceshipService.getSpaceshipById(Long.parseLong(spaceshipId));
            return "redirect:/showspaceship/" + spaceship.getSpaceshipId();
        } catch (ApiException exception) {
            LOGGER.error(ViewConstants.EXCEPTION_MESSAGE.toString(), exception);
            model.addAttribute(ViewConstants.ERROR.toString(), getErrorCode(ViewConstants.ERROR_CODE.toString(), exception.getCode()));
            return ViewConstants.XLSPACESHIP_LIST_ALL.toString();
        }
    }

    @GetMapping("/challenge/{id}")
    public String challengeSpaceship(Model model, @PathVariable("id") String spaceshipId) {
        try {
            String userId = getUserName();

            if (spaceshipService.getSpaceshipsByUserName(userId).isEmpty()) {
                return handleEmptySpaceshipList(model);
            } else {
                return handleUserSpaceship(model, spaceshipId, userId);
            }

        } catch (ApiException | com.spaceship.user.client.UserApiException | com.spaceship.protocal.client.ProtocalApiException exception) {
            LOGGER.error(ViewConstants.EXCEPTION_MESSAGE.toString(), exception);
            model.addAttribute(ViewConstants.ERROR.toString(), getErrorCode(ViewConstants.ERROR_CODE.toString(), exception.hashCode()));
            return ViewConstants.XLSPACESHIP_LIST_ALL.toString();
        }
    }

    @GetMapping("/challengemulti/{id}/{sid}")
    public String challenge(Model model, @PathVariable("id") String spaceshipId, @PathVariable("sid") String assmentSpaceId) {
        try {
            String userId = getUserName();
            gameService.createNewGame(userId, spaceshipId, assmentSpaceId);
            return "redirect:/game/list";
        } catch (ApiException | com.spaceship.user.client.UserApiException | com.spaceship.protocal.client.ProtocalApiException exception) {
            LOGGER.error(ViewConstants.EXCEPTION_MESSAGE.toString(), exception);
            model.addAttribute(ViewConstants.ERROR.toString(), getErrorCode(ViewConstants.ERROR_CODE.toString(), exception.hashCode()));
            return ViewConstants.XLSPACESHIP_LIST_ALL.toString();
        }
    }

    @GetMapping("/showspaceship/{id}")
    public String showSpaceShip(Model model, @PathVariable("id") Long spaceshipId) {
        try {
            model.addAttribute(ViewConstants.SPACESHIP_BOARD.toString(), spaceshipService.getSpaceships(spaceshipId));
            model.addAttribute(ViewConstants.SPACESHIP_BOARD_ARRAY.toString(), getBoardAsArray(spaceshipService.getSpaceships(spaceshipId).getBoard()));
            model.addAttribute(ViewConstants.SPACESHIP_SHAPES.toString(), spaceshipService.getSpaceshipsShape(spaceshipId));
            model.addAttribute(ViewConstants.SPACESHIP_REQUEST.toString(), new SpaceshipRequest());
            model.addAttribute(ViewConstants.SPACESHIP_ID.toString(), spaceshipId);
            return ViewConstants.SPACEBOARD.toString();

        } catch (ApiException exception) {
            LOGGER.error(ViewConstants.EXCEPTION_MESSAGE.toString(), exception);
            return "redirect:/getuserspaceships/" + getUserName();
        }
    }

    @GetMapping("/showspaceshiperror/{id}/{error}")
    public String showSpaceShipError(Model model, @PathVariable("error") String error, @PathVariable("id") Long spaceshipId) {
        try {
            model.addAttribute("spaceShipBoard", spaceshipService.getSpaceships(spaceshipId));
            model.addAttribute(ViewConstants.SPACESHIP_BOARD_ARRAY.toString(), getBoardAsArray(spaceshipService.getSpaceships(spaceshipId).getBoard()));
            model.addAttribute("spaceShipShapes", spaceshipService.getSpaceshipsShape(spaceshipId));
            model.addAttribute("spaceshipReq", new SpaceshipRequest());
            model.addAttribute("spaceshipId", spaceshipId);
            model.addAttribute("error", error);
            return "spaceship/spaceship_board";
        } catch (ApiException e) {
            return "";
        }
    }

    @PostMapping("/addspaceship")
    public String addSpaceShip(Model model, @Valid @ModelAttribute SpaceshipRequest spaceshipRequest, BindingResult result, @RequestParam("spaceshipId") Long spaceshipId) {
        try {

            if (result.hasErrors()) {
                model.addAttribute(ViewConstants.ERROR.toString(), getErrorCode(ViewConstants.ERROR_CODE.toString(), 411));
                model.addAttribute("spaceshipId", spaceshipId);
                return getErrorURL(spaceshipId, 411);
            }

            spaceshipService.addSpaceship(spaceshipRequest, spaceshipId);

            model.addAttribute("spaceShipBoard", spaceshipService.getSpaceships(spaceshipId));
            model.addAttribute(ViewConstants.SPACESHIP_BOARD_ARRAY.toString(), getBoardAsArray(spaceshipService.getSpaceships(spaceshipId).getBoard()));
            model.addAttribute("spaceShipShapes", spaceshipService.getSpaceshipsShape(spaceshipId));
            model.addAttribute("spaceshipReq", new SpaceshipRequest());
            model.addAttribute("spaceshipId", spaceshipId);

            return "spaceship/spaceship_board";
        } catch (ApiException exception) {
            LOGGER.error(ViewConstants.EXCEPTION_MESSAGE.toString(), exception);
            model.addAttribute(ViewConstants.ERROR.toString(), getErrorCode(ViewConstants.ERROR_CODE.toString(), exception.hashCode()));
            model.addAttribute("spaceshipId", spaceshipId);
            return getExceptionUrl(spaceshipId, exception);
        }
    }

    private String getExceptionUrl(Long spaceshipId, ApiException e) {
        return getErrorURL(spaceshipId, e.getCode());
    }

    private String getErrorURL(Long spaceshipId, Integer errorCode) {
        StringBuilder url = new StringBuilder();
        url.append("redirect:/showspaceshiperror/");
        url.append(spaceshipId);
        url.append("/");
        url.append(errorCode);
        return url.toString();
    }

    private String handleUserSpaceship(Model model, String spaceshipId, String userId)
            throws ApiException, com.spaceship.user.client.UserApiException, com.spaceship.protocal.client.ProtocalApiException {
        if (spaceshipService.getSpaceshipsByUserName(userId).size() > 1) {
            model.addAttribute("spaceships", spaceshipService.getSpaceshipsByUserName(userId));
            model.addAttribute("userinfo", "user.info.challenge");
            model.addAttribute("assmentSpace", spaceshipId);
            return "spaceship/xlspaceship_list";
        } else {

            InlineResponse2001 spaceship = spaceshipService.getSpaceshipsByUserName(userId).get(0);
            SpaceshipBoard spaceshipBoard = spaceshipService.getSpaceships(spaceship.getSpaceshipId());

            if (spaceshipBoard.getSpaceshipsType().isEmpty()) {
                model.addAttribute("spaceships", spaceshipService.getSpaceshipsByUserName(userId));
                model.addAttribute("emptySpaceships", "spaceship.empty");
                return "spaceship/xlspaceship_list";

            } else {
                gameService.createNewGame(userId, spaceshipId);
                return "redirect:/game/list";
            }

        }
    }

    private String handleEmptySpaceshipList(Model model) {
        model.addAttribute("emptyXLspaceships", "user.empty.spaceships");
        model.addAttribute("spaceships", new ArrayList<InlineResponse2001>());
        return "spaceship/xlspaceship_list";
    }

}
