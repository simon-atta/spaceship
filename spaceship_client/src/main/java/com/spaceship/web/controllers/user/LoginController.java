package com.spaceship.web.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spaceship.web.model.vo.User;

@Controller
public class LoginController {

    private static final String USER_VIEW = "user/login_user";

    /**
     * Get login view page.
     *
     * @param model
     *        Model
     * @return page path.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(Model model) {
        model.addAttribute("user", new User());
        return USER_VIEW;
    }

}
