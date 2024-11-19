package com.vinodspringboot.todo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Configuration
public class SecurityConfigaration {

    //private UserDetails userDetails = UserDetailsManagerConfigurer.UserDetailsBuilder().
//    InMemoryUserDetailsManager inMemoryUsers = new InMemoryUserDetailsManager(userDetails);

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        Function<String, String> passwordEncoded = input -> passwordEncoder().encode(input);

        List<UserDetails> users = new ArrayList<>();
        users.add(createUser("vinod", "password"));
        users.add(createUser("test", "password"));

        return new InMemoryUserDetailsManager(users);

    }

    private UserDetails createUser(String name, String password) {
        UserDetails userdetails = User.builder().passwordEncoder(input -> passwordEncoder().encode(input))
                .username(name)
                .password(password).roles("USER", "ADMIN")
                .build();

        return userdetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        http.formLogin(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        http.headers(header -> header.frameOptions(frameOptionsConfig -> frameOptionsConfig.disable()));
        return http.build();

    }
}
