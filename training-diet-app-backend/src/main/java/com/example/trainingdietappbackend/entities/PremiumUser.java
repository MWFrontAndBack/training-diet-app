package com.example.trainingdietappbackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Calendar;

@Entity
@Table(name = "premium_user")
@Getter
@Setter
@NoArgsConstructor
public class PremiumUser extends User{
    private double hipsCircumference;
    private double waistCircumference;
    private LocalDate startSubscription;
    private LocalDate endSubscription;
    // kalenadarz treningowy
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "calendar_id" ,referencedColumnName = "id")
    private TrainingCalendar calendar;
}
