package com.spaceship.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.spaceship.model.vo.board.SpaceshipBoardRequest;
import com.spaceship.util.SpaceshipFactory;

public class SpaceshipRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return SpaceshipBoardRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors error) {
        SpaceshipBoardRequest vSalvoShotRequest = (SpaceshipBoardRequest) target;

        if (!SpaceshipFactory.getSpaceships().containsKey(vSalvoShotRequest.getSpaceShipName())) {
            error.rejectValue("spaceShipName", "spaceShipName.invaildspaceship");
        }



    }

}
