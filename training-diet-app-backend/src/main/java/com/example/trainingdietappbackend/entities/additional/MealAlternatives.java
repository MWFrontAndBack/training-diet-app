package com.example.trainingdietappbackend.entities.additional;

import com.example.trainingdietappbackend.entities.Dishes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class MealAlternatives {
    private Dishes dish;
    private List<Dishes> alternatives;

    public MealAlternatives(Dishes dish, List<Dishes> alternatives) {
        this.dish = dish;
        this.alternatives = alternatives;
    }
}
