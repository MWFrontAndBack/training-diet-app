package com.example.trainingdietappbackend.entities;

import com.example.trainingdietappbackend.entities.enums.TrainingType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exercise")
@Builder

@AllArgsConstructor
@NoArgsConstructor
public class Excercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String photo;
    private int series;
    private int reps;
    // machiny dodać
    @Enumerated(EnumType.STRING)
    private TrainingType trainingType;
    @Min(1)
    @Max(5)
    private int levelOfAdvance;
    @JsonBackReference

    @ManyToOne
    @JoinColumn(name ="training_id" )
    private Training training;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "machine_id" ,referencedColumnName = "id")
  private TrainingMachine  machine;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public TrainingType getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(TrainingType trainingType) {
        this.trainingType = trainingType;
    }

    public int getLevelOfAdvance() {
        return levelOfAdvance;
    }

    public void setLevelOfAdvance(int levelOfAdvance) {
        this.levelOfAdvance = levelOfAdvance;
    }

    public TrainingMachine getMachine() {
        return machine;
    }

    public void setMachine(TrainingMachine machine) {
        this.machine = machine;
    }

    @Override
    public String toString() {
        return "Excercise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", series=" + series +
                ", reps=" + reps +
                ", trainingType=" + trainingType +
                ", levelOfAdvance=" + levelOfAdvance +
                '}';
    }
}
