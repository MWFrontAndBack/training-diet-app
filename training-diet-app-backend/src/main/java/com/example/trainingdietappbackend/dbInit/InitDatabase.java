package com.example.trainingdietappbackend.dbInit;


import com.example.trainingdietappbackend.entities.*;
import com.example.trainingdietappbackend.repositories.NoteRepository;
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
    CommandLineRunner commandLineRunner(NoteRepository noteRepository, UserRepository userRepository)
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




                Note note1 = Note.builder()
                        .title("Meeting Notes")
                        .content("Discussion about project timeline and deliverables.")
                        .noteCategory(NoteCategory.FAMILY)
                        .owner(user)
                        .build();

                Note note2 = Note.builder()
                        .title("Recipe Idea")
                        .content("A new recipe for a delicious pasta dish with fresh ingredients.")
                        .noteCategory(NoteCategory.FAMILY)
                        .owner(user)
                        .build();

                Note note3 = Note.builder()
                        .title("Travel Recommendations")
                        .content("Must-visit places and hidden gems in a popular travel destination.")
                        .noteCategory(NoteCategory.HOBBY)
                        .owner(user)
                        .build();

                Note note4 = Note.builder()
                        .title("Book Review")
                        .content("Thoughts and insights on an inspiring novel I recently read.")
                        .noteCategory(NoteCategory.FAMILY)
                        .owner(user)
                        .build();

                Note note5 = Note.builder()
                        .title("Fitness Tips")
                        .content("Useful exercises and diet recommendations for maintaining a healthy lifestyle.")
                        .noteCategory(NoteCategory.SPORT)
                        .owner(user)
                        .build();

                user.setNoteList(Arrays.asList(note1,note2,note3,note4,note5));
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

                Note note1User1 = Note.builder()
                        .title("User 1 Note 1")
                        .content("Content for User 1 Note 1")
                        .noteCategory(NoteCategory.FAMILY)
                        .owner(user1)
                        .build();

                Note note2User1 = Note.builder()
                        .title("User 1 Note 2")
                        .content("Content for User 1 Note 2")
                        .noteCategory(NoteCategory.HOBBY)
                        .owner(user1)
                        .build();

                user1.setNoteList(Arrays.asList(note1User1, note2User1));
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

                Note note1User2 = Note.builder()
                        .title("User 2 Note 1")
                        .content("Content for User 2 Note 1")
                        .noteCategory(NoteCategory.HOBBY)
                        .owner(user2)
                        .build();

                Note note2User2 = Note.builder()
                        .title("User 2 Note 2")
                        .content("Content for User 2 Note 2")
                        .noteCategory(NoteCategory.SPORT)
                        .owner(user2)
                        .build();

                user2.setNoteList(Arrays.asList(note1User2, note2User2));
                user2.setAuthorities(authorities2);
                userRepository.save(user2);

//                save admin to Database
                String encode4 =passwordEncoder.encode("admin");
                List<Note> emptyNotes =new ArrayList<>();

                Admin admin =  new Admin(emptyNotes,"admin","admin@gmail.com",encode4,"https://as1.ftcdn.net/v2/jpg/03/46/83/96/1000_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg",true);
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
