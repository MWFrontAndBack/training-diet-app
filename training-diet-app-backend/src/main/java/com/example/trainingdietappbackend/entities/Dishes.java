package com.example.trainingdietappbackend.entities;

import com.example.trainingdietappbackend.entities.enums.MealType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="dish")

@Builder

@AllArgsConstructor
@NoArgsConstructor
public class Dishes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonBackReference

    @ManyToOne
    @JoinColumn(name ="diet_id" )
    private Diet diet;

    private String name;
    private String photo;
    private double calories;
    private MealType mealType;
}
