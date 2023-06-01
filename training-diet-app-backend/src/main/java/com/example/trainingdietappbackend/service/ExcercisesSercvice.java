package com.example.trainingdietappbackend.service;

import com.example.trainingdietappbackend.entities.Excercise;
import com.example.trainingdietappbackend.entities.additional.ExcerciseAndAlternatives;
import com.example.trainingdietappbackend.entities.enums.TrainingType;

import java.util.List;

public interface ExcercisesSercvice {

    public List<ExcerciseAndAlternatives> getFOURExcercisesSpecifiedbyTrainngType(TrainingType trainingType);

    public  List<Excercise> findDifferent(List<Excercise> excercises,TrainingType trainingType);
}
