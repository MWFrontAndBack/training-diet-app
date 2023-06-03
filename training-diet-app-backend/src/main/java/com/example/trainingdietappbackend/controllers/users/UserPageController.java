package com.example.trainingdietappbackend.controllers.users;


import com.example.trainingdietappbackend.dto.UserDto;
import com.example.trainingdietappbackend.dto.mapper.mapperUtil.MapperUtil;
import com.example.trainingdietappbackend.entities.*;
import com.example.trainingdietappbackend.entities.additional.ExcerciseAndAlternatives;
import com.example.trainingdietappbackend.entities.additional.MealAlternatives;
import com.example.trainingdietappbackend.entities.enums.MealType;
import com.example.trainingdietappbackend.entities.enums.TrainingType;
import com.example.trainingdietappbackend.repositories.*;
import com.example.trainingdietappbackend.service.ExcerciseServiceImplement;
import com.example.trainingdietappbackend.service.MealServiceImplement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/user-page")
@CrossOrigin(origins = "*")
public class UserPageController {

    ExcerciseServiceImplement excerciseServiceImplement;
    private static final Logger logger = LoggerFactory.getLogger(UserPageController.class);
private TrainingRepository trainingRepository;
    private UserRepository userRepository;
    private ExcerciserRepository excerciserRepository;
    private MealServiceImplement mealsServiceImplement;
private DietRepository dietRepository;
private DishesRepostiory dishesRepostiory;



    public UserPageController(ExcerciseServiceImplement excerciseServiceImplement, TrainingRepository trainingRepository, UserRepository userRepository, ExcerciserRepository excerciserRepository, MealServiceImplement mealsServiceImplement, DietRepository dietRepository, DishesRepostiory dishesRepostiory) {
        this.excerciseServiceImplement = excerciseServiceImplement;
        this.trainingRepository = trainingRepository;
        this.userRepository = userRepository;
        this.excerciserRepository = excerciserRepository;
        this.mealsServiceImplement = mealsServiceImplement;
        this.dietRepository = dietRepository;
        this.dishesRepostiory = dishesRepostiory;
    }

@CrossOrigin
    @RequestMapping("/trainings")
    public ResponseEntity<List<Training>> getUserTraining() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = (String) authentication.getPrincipal();
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        return ResponseEntity.ok().body(user.getTrainings());
    }

    @CrossOrigin
    @RequestMapping("/diets")
    public ResponseEntity<List<Diet>> getUserDiets() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = (String) authentication.getPrincipal();
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        return ResponseEntity.ok().body(user.getDiets());
    }

    @RequestMapping("/account")
    public ResponseEntity<UserDto> getAccoutInfo() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = (String) authentication.getPrincipal();
        User user = userRepository.findByEmail(email);
        UserDto mapperUser = MapperUtil.map(user, UserDto.class);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(mapperUser);


    }

    @PostMapping
    @RequestMapping("/excercises")
    public ResponseEntity<List<ExcerciseAndAlternatives>> get4Excercises( @RequestParam("type")TrainingType type) {
        List<ExcerciseAndAlternatives> excercises = excerciseServiceImplement.getFOURExcercisesSpecifiedbyTrainngType(type);

return ResponseEntity.ok(excercises);
    }

    @PostMapping
    @RequestMapping("/meals")
    public ResponseEntity<List<MealAlternatives>> get4Meals( @RequestParam("type") MealType type) {
        logger.info("fetch data");
        List<MealAlternatives> meals = mealsServiceImplement.getFOURMealsSpecifiedbMealType(type);
        logger.info("meals alt size" +meals.size());
        return ResponseEntity.ok(meals);
    }

    @PostMapping
    @RequestMapping("/save-training")
public ResponseEntity<String> saveTrainingToDb(@RequestBody Training training){
        logger.info("trainig-saved" + training);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = (String) authentication.getPrincipal();
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        training.setOwner(user);

        for (Excercise exercise : training.getExcercieses()) {
            exercise.setTraining(training);
        }

        trainingRepository.save(training);
        excerciserRepository.saveAll(training.getExcercieses());
        return ResponseEntity.ok("saved");
    }


    @PostMapping
    @RequestMapping("/save-diet")
    public ResponseEntity<String> saveDietToDb(@RequestBody Diet diet){
        logger.info("trainig-saved" + diet);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = (String) authentication.getPrincipal();
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        diet.setOwner(user);

        for (Dishes dish : diet.getDishesList()) {
            dish.setDiet(diet);
        }

        logger.info("diet phto" + diet.getUrl());
        dietRepository.save(diet);
        dishesRepostiory.saveAll(diet.getDishesList());
        return ResponseEntity.ok("saved");
    }

    @DeleteMapping
    @RequestMapping(("/delete-training/{id}"))
    public ResponseEntity<Training> delteTraining(@PathVariable(name = "id") Long id) {
        logger.error("logger");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = (String) authentication.getPrincipal();
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Training delted = trainingRepository.findById(id).orElseThrow();

for(Excercise exercise: delted.getExcercieses()){
    exercise.setTraining(null);
    excerciserRepository.save(exercise);
}



        trainingRepository.delete(delted);


        return ResponseEntity.ok(delted);


    }
    @DeleteMapping
    @RequestMapping(("/delete-diet/{id}"))
    public ResponseEntity<Diet> delteDiet(@PathVariable(name = "id") Long id) {
        logger.error("logger");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = (String) authentication.getPrincipal();
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Diet delted = dietRepository.findById(id).orElseThrow();

        for(Dishes dish: delted.getDishesList()){
            dish.setDiet(null);
            dishesRepostiory.save(dish);
        }
        dietRepository.delete(delted);


        return ResponseEntity.ok(delted);


    }

}
