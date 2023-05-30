package com.example.trainingdietappbackend.dbInit;


import com.example.trainingdietappbackend.entities.*;
import com.example.trainingdietappbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

@Configuration
public class InitDatabase {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner commandLineRunner( UserRepository userRepository)
        {
            return args -> {

String encode =passwordEncoder.encode("haslo");
                User user = User.builder()
                        .photo("https://as1.ftcdn.net/v2/jpg/03/46/83/96/1000_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg")
                        .loginName("kacper")
                        .password(encode)
                        .email("kacper@gmail.com")
                        .build();


                Authority authority =new Authority();
                authority.setAuthority("ROLE_USER");
                Set<Authority> authorities = new HashSet<>();
                authorities.add(authority);
                authority.setUser(user);





                user.setAuthorities(authorities);

                userRepository.save(user);
                String encode1 = passwordEncoder.encode("password1");
                User user1 = User.builder()
                        .photo("https://as1.ftcdn.net/v2/jpg/03/46/83/96/1000_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg")
                        .loginName("user1")
                        .password(encode1)
                        .email("user1@gmail.com")
                        .build();

                Authority authority1 = new Authority();
                authority1.setAuthority("ROLE_USER");
                Set<Authority> authorities1 = new HashSet<>();
                authorities1.add(authority1);
                authority1.setUser(user1);


                user1.setAuthorities(authorities1);

                userRepository.save(user1);

                String encode2 = passwordEncoder.encode("password2");
                User user2 = User.builder()
                        .photo("https://as1.ftcdn.net/v2/jpg/03/46/83/96/1000_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg")
                        .loginName("user2")
                        .password(encode2)
                        .email("user2@gmail.com")
                        .build();

                Authority authority2 = new Authority();
                authority2.setAuthority("ROLE_USER");
                Set<Authority> authorities2 = new HashSet<>();
                authorities2.add(authority2);
                authority2.setUser(user2);


                user2.setAuthorities(authorities2);
                userRepository.save(user2);

//                save admin to Database
                String encode4 =passwordEncoder.encode("admin");

                Admin admin =  new Admin("admin","admin@gmail.com",encode4,"https://as1.ftcdn.net/v2/jpg/03/46/83/96/1000_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg",true,true,true);
                Authority authorityAdmin =new Authority();
                authorityAdmin.setAuthority("ROLE_ADMIN");
                Set<Authority> authoritiesAdmin = new HashSet<>();
                authoritiesAdmin.add(authorityAdmin);

                authorityAdmin.setUser(admin);
                admin.setAuthorities(authoritiesAdmin);



userRepository.save(admin);


            };

    }
}
