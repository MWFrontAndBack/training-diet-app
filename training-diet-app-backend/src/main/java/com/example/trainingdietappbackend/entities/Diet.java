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
    private String URL;
    @JsonBackReference

    @ManyToOne
    @JoinColumn(name ="user_id" )
    private User owner;
    @JsonManagedReference
    @OneToMany(mappedBy = "diet", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Dishes> dishesList;

    @JsonManagedReference
    @OneToMany(mappedBy = "diet", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<AllergicIngredients> allergicIngredients;
}
