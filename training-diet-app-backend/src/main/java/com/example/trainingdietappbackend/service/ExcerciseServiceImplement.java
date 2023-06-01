package com.example.trainingdietappbackend.service;

import com.example.trainingdietappbackend.controllers.users.UserPageController;
import com.example.trainingdietappbackend.entities.Excercise;
import com.example.trainingdietappbackend.entities.additional.ExcerciseAndAlternatives;
import com.example.trainingdietappbackend.entities.enums.TrainingType;
import com.example.trainingdietappbackend.repositories.ExcerciserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExcerciseServiceImplement implements ExcercisesSercvice {
    @Autowired
    ExcerciserRepository excerciserRepository;

    private static final Logger logger = LoggerFactory.getLogger(ExcerciseServiceImplement.class);


    private  List<Excercise> used = new ArrayList<>();



    @Override
    public List<ExcerciseAndAlternatives> getFOURExcercisesSpecifiedbyTrainngType(TrainingType trainingType) {
        List<ExcerciseAndAlternatives> excerciseAndAlternativesList = new ArrayList<>();
        List<Excercise> fourWithTrainingType = excerciserRepository.findAll().stream().filter(t->t.getTrainingType().equals(trainingType)).limit(4).toList();
        used.addAll(fourWithTrainingType);
        fourWithTrainingType.forEach(t -> {
            ExcerciseAndAlternatives alternatives = new ExcerciseAndAlternatives();
            alternatives.setExcercise(t);
            List<Excercise> different = findDifferent(used,t.getTrainingType());


            alternatives.setAlternatives(different);

            excerciseAndAlternativesList.add(alternatives);

        });
        return excerciseAndAlternativesList;

    }

    @Override
    public List<Excercise> findDifferent(List<Excercise> base,TrainingType trainingType) {
        List<Excercise> differentTwo = excerciserRepository.findAll();
        differentTwo.removeAll(base);
        List<Excercise> limited = differentTwo.stream().filter(t -> t.getTrainingType().equals(trainingType)).limit(2).collect(Collectors.toList());

        if(limited.size()==2) {
            logger.info("limited" +limited.get(0));
            logger.info("limited " +limited.get(1));
            used.add(limited.get(0));
            used.add(limited.get(1));
        }
        logger.info("użyte" + used);

        return limited;
    }
}
