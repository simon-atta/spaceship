package com.spaceship.protocal.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.spaceship.protocal.model.vo.game.fire.SalvoShotRequest;

@Component
public class SalvoShotValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return SalvoShotRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors error) {
        SalvoShotRequest vSalvoShotRequest = (SalvoShotRequest) target;

        if (null != vSalvoShotRequest.getSalvo() && vSalvoShotRequest.getSalvo().isEmpty()) {
            error.rejectValue("salvo", "salvo.null");
        }


    }

}
