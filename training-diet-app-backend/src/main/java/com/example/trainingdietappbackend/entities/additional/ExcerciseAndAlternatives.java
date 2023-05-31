package com.example.trainingdietappbackend.entities.additional;

import com.example.trainingdietappbackend.entities.Excercise;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class ExcerciseAndAlternatives {

    private Excercise excercise;
    private List<Excercise> alternatives;

    public ExcerciseAndAlternatives(Excercise excercise, List<Excercise> alternatives) {
        this.excercise = excercise;
        this.alternatives = alternatives;
    }

}
