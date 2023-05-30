package com.example.trainingdietappbackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="alergic_ingredients")

@Builder

@AllArgsConstructor
@NoArgsConstructor
public class AllergicIngredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name ="diet_id" )
    private Diet diet;
    private String name;
    private String photo;
    private String description;


}
