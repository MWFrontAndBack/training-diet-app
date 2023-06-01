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

@Service
public class ExcerciseServiceImplement implements ExcercisesSercvice {
    @Autowired
    ExcerciserRepository excerciserRepository;

    private static final Logger logger = LoggerFactory.getLogger(ExcerciseServiceImplement.class);

    @Override
    public List<ExcerciseAndAlternatives> getFOURExcercisesSpecifiedbyTrainngType(TrainingType trainingType) {
        List<ExcerciseAndAlternatives> excerciseAndAlternativesList = new ArrayList<>();
        List<Excercise> fourWithTrainingType = excerciserRepository.findFOURWithTrainingType(trainingType).stream().limit(4).toList();
        fourWithTrainingType.forEach(t -> {
            ExcerciseAndAlternatives alternatives = new ExcerciseAndAlternatives();
            alternatives.setExcercise(t);
            List<Excercise> different = findDifferent(fourWithTrainingType,t.getTrainingType());


            alternatives.setAlternatives(different);

            excerciseAndAlternativesList.add(alternatives);

        });
        return excerciseAndAlternativesList;

    }

    @Override
    public List<Excercise> findDifferent(List<Excercise> base,TrainingType trainingType) {
        List<Excercise> differentTwo = new ArrayList<>(new ArrayList<>(excerciserRepository.findAll().stream().filter(l -> l.getTrainingType().equals(trainingType)).toList()).stream().limit(2).toList());
        logger.info("different" + differentTwo);

        differentTwo.removeAll(base);
//        if(differentTwo.isEmpty()){
//            differentTwo.add(new Excercise());
//            logger.info("differnet" + differentTwo);
//
//        }
        return differentTwo;
    }
}
