package com.example.trainingdietappbackend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Table(name = "statistics")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(mappedBy = "statistics")
    private User user;
    @JsonManagedReference
    @OneToMany(mappedBy = "statistic", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<MaxExericise> maxExericiseList;

}
