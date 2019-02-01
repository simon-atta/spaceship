package com.spaceship.protocal.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.spaceship.protocal.model.vo.game.create.GameRequest;

@Component
public class GameRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return GameRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors error) {
        GameRequest vGameRequest = (GameRequest) target;
        if (vGameRequest.getPlayers().size() == 0) {
            error.rejectValue("players", "challengerPlayer.null");
        }

        if (vGameRequest.getPlayers().size() > 2) {
            error.rejectValue("players", "challengerPlayer.max");
        }

    }

}
