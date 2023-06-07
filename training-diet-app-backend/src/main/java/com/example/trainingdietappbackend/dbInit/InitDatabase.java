package com.example.trainingdietappbackend.dbInit;


import com.example.trainingdietappbackend.entities.*;
import com.example.trainingdietappbackend.entities.enums.MealType;
import com.example.trainingdietappbackend.entities.enums.TrainingType;
import com.example.trainingdietappbackend.repositories.DietRepository;
import com.example.trainingdietappbackend.repositories.DishesRepostiory;
import com.example.trainingdietappbackend.repositories.ExcerciserRepository;
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
    CommandLineRunner commandLineRunner(UserRepository userRepository, ExcerciserRepository excerciserRepository, DietRepository dietRepository, DishesRepostiory dishesRepostiory) {
        return args -> {

            String encode = passwordEncoder.encode("haslo");
            User user = User.builder()
                    .photo("https://as1.ftcdn.net/v2/jpg/03/46/83/96/1000_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg")
                    .loginName("kacper")
                    .password(encode)
                    .email("kacper@gmail.com")
                    .build();


            Authority authority = new Authority();
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
            String encode4 = passwordEncoder.encode("admin");

            Admin admin = new Admin("admin", "admin@gmail.com", encode4, "https://as1.ftcdn.net/v2/jpg/03/46/83/96/1000_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg", true, true, true);
            Authority authorityAdmin = new Authority();
            authorityAdmin.setAuthority("ROLE_ADMIN");
            Set<Authority> authoritiesAdmin = new HashSet<>();
            authoritiesAdmin.add(authorityAdmin);

            authorityAdmin.setUser(admin);
            admin.setAuthorities(authoritiesAdmin);


//                save some excercises to db
            Excercise exercise1 = Excercise.builder()
                    .name("MyExercie 1")
                    .photo("exercise1.jpg")
                    .series(3)
                    .reps(10)
                    .trainingType(TrainingType.MOBILITY)
                    .levelOfAdvance(5)
                    .build();

            Excercise exercise2 = Excercise.builder()
                    .name("MyExercie 2")
                    .photo("exercise2.jpg")
                    .series(4)
                    .reps(12)
                    .trainingType(TrainingType.STRENGTH)
                    .levelOfAdvance(4)
                    .build();

            Excercise exercise3 = Excercise.builder()
                    .name("MyExercie 3")
                    .photo("exercise3.jpg")
                    .series(5)
                    .reps(15)
                    .trainingType(TrainingType.ENDURANCE)
                    .levelOfAdvance(3)
                    .build();

            Excercise exercise4 = Excercise.builder()
                    .name("MyExercie 4")
                    .photo("exercise4.jpg")
                    .series(3)
                    .reps(8)
                    .trainingType(TrainingType.STRENGTH)
                    .levelOfAdvance(5)
                    .build();

            Excercise exercise5 = Excercise.builder()
                    .name("MyExercie 5")
                    .photo("exercise5.jpg")
                    .series(4)
                    .reps(10)
                    .trainingType(TrainingType.MOBILITY)
                    .levelOfAdvance(4)
                    .build();

            Excercise exercise6 = Excercise.builder()
                    .name("MyExercie 6")
                    .photo("exercise6.jpg")
                    .series(3)
                    .reps(12)
                    .trainingType(TrainingType.ENDURANCE)
                    .levelOfAdvance(3)
                    .build();


            Excercise exercise7 = Excercise.builder()
                    .name("MyExercie 15")
                    .photo("exercise15.jpg")
                    .series(5)
                    .reps(15)
                    .trainingType(TrainingType.STRENGTH)
                    .levelOfAdvance(4)
                    .build();
            List<Excercise> exercises = new ArrayList<>();
            exercises.add(exercise1);
            exercises.add(exercise2);
            exercises.add(exercise3);
            exercises.add(exercise4);
            exercises.add(exercise5);
            exercises.add(exercise6);
            exercises.add(exercise7);


            for (int i = 1; i <= 40; i++) {
                Excercise exercise = Excercise.builder()
                        .name("Exercise " + i)
                        .photo("exercise" + i + ".jpg")
                        .series(i % 5 + 1)
                        .reps(i % 10 + 5)
                        .trainingType(TrainingType.values()[i % 3])
                        .levelOfAdvance(i % 5 + 1)
                        .build();

                exercises.add(exercise);
            }
            excerciserRepository.saveAll(exercises);
            Random ranomalg = new Random();


            List<Dishes> dishesInit = new ArrayList<>();
            for (int i = 1; i <= 40; i++) {
                int randomNumber = ranomalg.nextInt(3);

                int random = (int) (Math.random() * (700 - 100)) + 300;
                Dishes dishes = Dishes.builder()
                        .name("Dish " + i)
                        .photo("exercise" + i + ".jpg")

                                .calories(random).mealType(MealType.values()[i%3]).build();
                AllergicIngredients al1 = AllergicIngredients.builder().name("orzechy").photo("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRNgDj6iUc4VGldBvCcMkjFFqbbdclnJrQ3hQ&usqp=CAU").description("Orzechy włoskie,Orzechy laskowe, Orzechy arachidowe, zwane fistaszkami").build();
                AllergicIngredients al2 = AllergicIngredients.builder().name("kakao").photo("https://i0.wp.com/www.palarniakawyjawa.pl/wp-content/uploads/2019/10/Kakao_s.jpg?fit=300%2C300&ssl=1").description("Kakao to ciemnobrązowy proszek, który powstaje z nasion kakaowca. Są one czyszczone, sortowane, poddawane fermentacji, prażeniu, łuszczeniu, rozdrobnieniu i odtłuszczeniu. ").build();
                AllergicIngredients al3 = AllergicIngredients.builder().name("jajka").photo("https://radioolsztyn.pl/wp-content/uploads/2017/11/jajka-1024x419.jpg").description("Przeciętne jajo kurze waży ok. 50 g, w tym skorupka i błony 5 g. Gęstość względna zależy od jego wieku i waha się w przedziale 1000–1096 g/dm³.").build();
                dishesInit.add(dishes);

                if (randomNumber == 0) {
                dishes.setIngridient(al1);

                al1.setDishes(dishes);}
                if (randomNumber == 1) {
                    dishes.setIngridient(al2);

                    al1.setDishes(dishes);}

                if (randomNumber == 2) {
                    dishes.setIngridient(al3);

                    al1.setDishes(dishes);}


            }
            dishesRepostiory.saveAll(dishesInit);

            userRepository.save(admin);


        };

    }
}
