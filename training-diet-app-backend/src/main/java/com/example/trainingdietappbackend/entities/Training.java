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
@Table(name ="training")

@Builder

@AllArgsConstructor
@NoArgsConstructor
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //user
    @Column(length = 300)
    private String name;
    // lista cwiczen
    private String photo;
    @Column(length = 500)
    private String description;
    private int maxAge;
    @JsonBackReference

    @ManyToOne
    @JoinColumn(name ="user_id" )
    private User owner;

    @JsonManagedReference
    @OneToMany(mappedBy = "training", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Excercise> excercieses = new ArrayList<>();


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public List<Excercise> getExcercieses() {
        return excercieses;
    }

    public void setExcercieses(List<Excercise> excercieses) {
        this.excercieses = excercieses;
    }
}
