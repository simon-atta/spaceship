package com.spaceship.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spaceship.model.vo.ship.XLSpaceshipRequest;

public class XLSpaceshipRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return XLSpaceshipRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors error) {
        ValidationUtils.rejectIfEmpty(error, "userId", "userId.empty");
    }


}
