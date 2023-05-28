package com.example.trainingdietappbackend.security;

import com.example.trainingdietappbackend.entities.Authority;
import com.example.trainingdietappbackend.entities.User;
import com.example.trainingdietappbackend.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
        User user = userRepository.findByEmail(email);

        if(user!=null &&passwordEncoder.matches(password,user.getPassword())){
            logger.error("istnieje");
            logger.error(email + " " + password + user.getAuthorities());

            return  new UsernamePasswordAuthenticationToken(email,password,getAuthorities(user.getAuthorities()));

        }else {
            throw new BadCredentialsException("invalid cridenticals");
        }
    }
    private List<SimpleGrantedAuthority> getAuthorities(Set<Authority> authorities){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for(Authority auth: authorities){
            list.add(new SimpleGrantedAuthority(auth.getAuthority()));
        }
        return list;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
