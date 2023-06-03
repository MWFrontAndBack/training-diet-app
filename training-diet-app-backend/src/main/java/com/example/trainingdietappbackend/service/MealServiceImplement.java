package com.example.trainingdietappbackend.service;

import com.example.trainingdietappbackend.entities.Dishes;
import com.example.trainingdietappbackend.entities.Excercise;
import com.example.trainingdietappbackend.entities.additional.ExcerciseAndAlternatives;
import com.example.trainingdietappbackend.entities.additional.MealAlternatives;
import com.example.trainingdietappbackend.entities.enums.MealType;
import com.example.trainingdietappbackend.entities.enums.TrainingType;
import com.example.trainingdietappbackend.repositories.DishesRepostiory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class MealServiceImplement implements MealService{

    @Autowired
    private DishesRepostiory dishesRepostiory;


    private static final Logger logger = LoggerFactory.getLogger(MealServiceImplement.class);
    private  List<Dishes> used = new ArrayList<>();

    @Override
    public List<MealAlternatives> getFOURMealsSpecifiedbMealType(MealType typeofMeal) {
        List<MealAlternatives> mealAndAlternatives = new ArrayList<>();
        List<Dishes> findFourMeals = dishesRepostiory.findAll().stream().filter(m -> m.getMealType().equals(typeofMeal)).limit(4).toList();
        logger.info("dishes" + findFourMeals);
        used.addAll(findFourMeals);
        findFourMeals.forEach(t ->{
            MealAlternatives alternatives = new MealAlternatives();
            alternatives.setDish(t);
          List<Dishes> different =  findDifferent(used,t.getMealType());
            alternatives.setAlternatives(different);
mealAndAlternatives.add(alternatives);
        });
        return mealAndAlternatives;
    }

    @Override
    public List<Dishes> findDifferent(List<Dishes> base, MealType mealType) {
        List<Dishes> differentTwo = dishesRepostiory.findAll();
        differentTwo.removeAll(base);
        List<Dishes> limited = differentTwo.stream().filter(t -> t.getMealType().equals(mealType)).limit(2).collect(Collectors.toList());
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
