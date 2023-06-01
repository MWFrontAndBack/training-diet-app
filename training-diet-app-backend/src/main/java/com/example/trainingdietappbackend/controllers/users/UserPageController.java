package com.example.trainingdietappbackend.controllers.users;


import com.example.trainingdietappbackend.dto.UserDto;
import com.example.trainingdietappbackend.dto.mapper.mapperUtil.MapperUtil;
import com.example.trainingdietappbackend.entities.Excercise;
import com.example.trainingdietappbackend.entities.Training;
import com.example.trainingdietappbackend.entities.User;
import com.example.trainingdietappbackend.entities.additional.ExcerciseAndAlternatives;
import com.example.trainingdietappbackend.entities.enums.TrainingType;
import com.example.trainingdietappbackend.repositories.ExcerciserRepository;
import com.example.trainingdietappbackend.repositories.TrainingRepository;
import com.example.trainingdietappbackend.repositories.UserRepository;
import com.example.trainingdietappbackend.service.ExcerciseServiceImplement;
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

    public UserPageController(ExcerciseServiceImplement excerciseServiceImplement, TrainingRepository trainingRepository, UserRepository userRepository, ExcerciserRepository excerciserRepository) {
        this.excerciseServiceImplement = excerciseServiceImplement;
        this.trainingRepository = trainingRepository;
        this.userRepository = userRepository;
        this.excerciserRepository = excerciserRepository;
    }

    //    private NoteRepository noteRepository;
//
//    public UserPageController(UserRepository userRepository, NoteRepository noteRepository) {
//        this.userRepository = userRepository;
//        this.noteRepository = noteRepository;
//    }
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


    @DeleteMapping
    @RequestMapping(("/delete-training/{id}"))
    public ResponseEntity<Training> deleteNote(@PathVariable(name = "id") Long id) {
        logger.error("logger");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = (String) authentication.getPrincipal();
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Training delted = trainingRepository.findById(id).orElseThrow();
        trainingRepository.deleteById(id);



        return ResponseEntity.ok(delted);


    }


}
