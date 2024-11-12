package com.vinodspringboot.todo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("hello")
    @ResponseBody
    public static String sayHello() {
        return "Hello World!";
    }

    @RequestMapping("hello-jsp")
    public static String sayHelloJsp(){
        return "sayHello";
    }
}
