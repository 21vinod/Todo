package com.vinodspringboot.todo.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String username, String password) {
        return username.equalsIgnoreCase("vinod") && password.equalsIgnoreCase("password");
    }
}
