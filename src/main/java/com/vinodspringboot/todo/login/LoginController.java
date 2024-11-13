package com.vinodspringboot.todo.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("login")
    public String login(@RequestParam String name, Model model){
        model.addAttribute("name",name);
        //understand logging levels error< warn(warn+error)<info<debug<trace
        log.trace("trace parameter: {}",name);
        log.debug("debug parameter: {}",name);
        log.info("info parameter: {}",name);
        log.warn("warn parameter: {}",name);
        log.error("error parameter: {}",name);
        return "login";
    }
}
