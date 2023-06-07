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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonBackReference

    @ManyToOne
    @JoinColumn(name ="diet_id" )
    private Diet diet;

    private String name;
    private String photo;
    private double calories;
    private MealType mealType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingredients_id" ,referencedColumnName = "id")
    private AllergicIngredients ingridient;

    public Long getId() {
        return id;
    }

    public AllergicIngredients getIngridient() {
        return ingridient;
    }

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }

    public double getCalories() {
        return calories;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public void setIngridient(AllergicIngredients ingridient) {
        this.ingridient = ingridient;
    }

    @Override
    public String toString() {
        return "Dishes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", calories=" + calories +
                ", mealType=" + mealType +
                '}';
    }
}
