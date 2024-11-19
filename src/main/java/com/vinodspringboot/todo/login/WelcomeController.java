package com.vinodspringboot.todo.login;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class WelcomeController {

    //private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String gotoWelcomePage(Model model) {
        // model.addAttribute("name",name);
//        String name = "vinod";
        //understand logging levels error< warn(warn+error)<info<debug<trace
//        log.trace("trace parameter: {}", name);
//        log.debug("debug parameter: {}", name);
//        log.info("info parameter: {}", name);
//        log.warn("warn parameter: {}", name);
//        log.error("error parameter: {}", name);
        model.addAttribute("username", getLoggedInUsername());
        return "welcome";
    }

    private String getLoggedInUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
