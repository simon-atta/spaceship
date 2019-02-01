package com.spaceship.web.controllers;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class AbstractController {

    public String getErrorCode(String name, Integer code) {
        StringBuilder errorCode = new StringBuilder();
        errorCode.append(name);
        errorCode.append(".");
        errorCode.append(code);
        return errorCode.toString();
    }

    public String getUserName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    public String[][] getBoardAsArray(List<List<String>> board) {
        String[][] array = new String[16][16];

        List<String> row = board.get(0);
        for (int i = 0; i < row.size(); i++) {
            array[i] = row.get(i).split("");
        }

        return array;
    }

}
