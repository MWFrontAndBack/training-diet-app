package com.example.trainingdietappbackend.service;

import com.example.trainingdietappbackend.entities.Excercise;
import com.example.trainingdietappbackend.entities.additional.ExcerciseAndAlternatives;
import com.example.trainingdietappbackend.entities.enums.TrainingType;
import com.example.trainingdietappbackend.repositories.ExcerciserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExcerciseServiceImplement implements ExcercisesSercvice {
    @Autowired
    ExcerciserRepository excerciserRepository;

    @Override
    public List<ExcerciseAndAlternatives> getFOURExcercisesSpecifiedbyTrainngType(TrainingType trainingType) {
        List<ExcerciseAndAlternatives> excerciseAndAlternativesList = new ArrayList<>();
        List<Excercise> fourWithTrainingType = excerciserRepository.findFOURWithTrainingType(trainingType).stream().limit(4).toList();
        fourWithTrainingType.forEach(t -> {
            ExcerciseAndAlternatives alternatives = new ExcerciseAndAlternatives();
            alternatives.setExcercise(t);
            List<Excercise> different = find2Different(t.getId(),t.getTrainingType());
            alternatives.setAlternatives(different);
            excerciseAndAlternativesList.add(alternatives);

        });
        return excerciseAndAlternativesList;

    }

    @Override
    public List<Excercise> find2Different(Long id,TrainingType trainingType) {
        List<Excercise> differentTwo = excerciserRepository.findDifferentTwo(id,trainingType).stream().limit(2).toList();
        return differentTwo;
    }
}
