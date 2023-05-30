package com.example.trainingdietappbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "max_exercise")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaxExericise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double bench;
    private int pullUps;
    private double squad;
    private double deadlift;
    @ManyToOne
    @JoinColumn(name ="statistics_id" )

     private Statistics statistic;
}

