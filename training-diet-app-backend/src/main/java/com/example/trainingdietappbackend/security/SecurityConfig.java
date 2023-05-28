package com.example.trainingdietappbackend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {


    @Autowired
    private CustomAuthenticationProvider authenticationProvider;

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .requestMatchers(new AntPathRequestMatcher("/api/public/create-user")).permitAll()

                .requestMatchers(new AntPathRequestMatcher("/api/public/login")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/api/public/user-page")).hasAnyRole("USER","ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/api/public/admin-page")).hasRole("ADMIN")

                .anyRequest().authenticated()
                .and()
                .httpBasic();


        return http.build();

    }

}