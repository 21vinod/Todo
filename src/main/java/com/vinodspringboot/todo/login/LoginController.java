package com.vinodspringboot.todo.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    public AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        // model.addAttribute("name",name);
        String name = "vinod";
        //understand logging levels error< warn(warn+error)<info<debug<trace
        log.trace("trace parameter: {}", name);
        log.debug("debug parameter: {}", name);
        log.info("info parameter: {}", name);
        log.warn("warn parameter: {}", name);
        log.error("error parameter: {}", name);
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        if (authenticationService.authenticate(username, password)) {
            model.addAttribute("username", username);
            return "welcome";
        }
        model.addAttribute("error", "Invalid username or password");
        return "login";
    }
}
