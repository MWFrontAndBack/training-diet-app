package com.example.trainingdietappbackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="diet")

@Builder

@AllArgsConstructor
@NoArgsConstructor
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int calories;
    private String dietName;
    @Column(length = 1000)

    private String url;
    @Column(length = 1000)
    private String description;
    @JsonBackReference

    @ManyToOne
    @JoinColumn(name ="user_id" )
    private User owner;
    @JsonManagedReference
    @OneToMany(mappedBy = "diet")
    private List<Dishes> dishesList;

    @JsonManagedReference
    @OneToMany(mappedBy = "diet", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<AllergicIngredients> allergicIngredients;

    public Long getId() {
        return id;
    }

    public List<Dishes> getDishesList() {
        return dishesList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }


    public String getDietName() {
        return dietName;
    }

    public void setDietName(String dietName) {
        this.dietName = dietName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<AllergicIngredients> getAllergicIngredients() {
        return allergicIngredients;
    }

    public void setAllergicIngredients(List<AllergicIngredients> allergicIngredients) {
        this.allergicIngredients = allergicIngredients;
    }
}
