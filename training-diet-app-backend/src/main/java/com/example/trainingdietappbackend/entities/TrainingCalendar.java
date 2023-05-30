package com.example.trainingdietappbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "calendar")

@Builder

@AllArgsConstructor
@NoArgsConstructor
public class TrainingCalendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Transient
    private Map<Training, String> plan = new HashMap<>();
    @OneToOne(mappedBy = "calendar")
    private PremiumUser premiumUser;
}
