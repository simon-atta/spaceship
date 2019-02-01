package com.spaceship.web.controllers.user;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spaceship.user.client.UserApiException;
import com.spaceship.web.model.vo.User;
import com.spaceship.web.services.user.IUserService;

@Controller
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class);
    private static final String EXCEPTION_MESSAGE = "Something went wrong!";
    private static final String CREATE_USER = "user/create_user";
    private static final String LIST_USER = "user/list_user";
    private static final String LOGIN_URL = "redirect:/login_user";

    @Autowired
    private IUserService userService;

    @GetMapping("/createuser")
    public String getUser(Model model) {
        model.addAttribute("user", new User());
        return CREATE_USER;
    }

    @GetMapping("/listusers")
    public String listAllUsers(Model model) {
        try {
            model.addAttribute("users", userService.getUserList());
            return LIST_USER;
        } catch (UserApiException exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            model.addAttribute("error", "user." + exception.getCode());
            return LIST_USER;
        }
    }

    @PostMapping("/createuser")
    public String createUser(@ModelAttribute User pUser, final Model model) {
        try {
            userService.createUser(pUser);
            return LOGIN_URL;
        } catch (UserApiException exception) {
            LOGGER.error(EXCEPTION_MESSAGE, exception);
            model.addAttribute("error", "user." + exception.getCode());
            return CREATE_USER;
        }
    }

}
