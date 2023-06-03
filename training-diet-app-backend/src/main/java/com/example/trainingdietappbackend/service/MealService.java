package com.example.trainingdietappbackend.service;

import com.example.trainingdietappbackend.entities.Dishes;
import com.example.trainingdietappbackend.entities.Excercise;
import com.example.trainingdietappbackend.entities.additional.ExcerciseAndAlternatives;
import com.example.trainingdietappbackend.entities.additional.MealAlternatives;
import com.example.trainingdietappbackend.entities.enums.MealType;
import com.example.trainingdietappbackend.entities.enums.TrainingType;

import java.util.List;

public interface MealService {

     List<MealAlternatives> getFOURMealsSpecifiedbMealType(MealType trainingType);

      List<Dishes> findDifferent(List<Dishes> excercises, MealType mealType);
}
