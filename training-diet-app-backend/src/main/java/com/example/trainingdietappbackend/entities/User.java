package com.example.trainingdietappbackend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Entity
@Table(name = "user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "user_id")
    private Long id;
    @Column(length = 200)
    private String firstName;
    @Column(length = 200)
    private String lastName;
    private LocalDate birthDate;
    private Double height;
    private Double weight;




    @JsonManagedReference
    @OneToMany(mappedBy = "owner", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Diet> diets = new ArrayList<>();
    private String loginName;

    @JsonProperty("email")

    private String email;


    @JsonProperty("password")

    private String password;

    private String photo;

    @JsonManagedReference

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Authority> authorities = new HashSet<>();


    @JsonManagedReference
    @OneToMany(mappedBy = "owner", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Training> trainings = new ArrayList<>();
    // Getters and Setters
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "statistics_id" ,referencedColumnName = "id")
private  Statistics statistics;

    public User( String loginName, String email, String password, String photo, Set<Authority> authorities) {
        this.loginName = loginName;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.authorities = authorities;
    }

    public User( String loginName, String email, String password, String photo) {
        this.loginName = loginName;
        this.email = email;
        this.password = password;
        this.photo = photo;
    }

    public User(Long id, String loginName, String email, String password) {
        this.id = id;
        this.loginName = loginName;
        this.email = email;
        this.password = password;
    }

    public User(String loginName, String email, String password) {
        this.loginName = loginName;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Diet> getDiets() {
        return diets;
    }

    public void setDiets(List<Diet> diets) {
        this.diets = diets;
    }

    public String getLoginName() {
        return loginName;
    }


    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public long calculateAte(){
        return  ChronoUnit.YEARS.between(birthDate,LocalDate.now());

    }
    public List<Training> showTrainings(){
        return getTrainings();
    }
    public List<Diet> showDiets(){
        return getDiets();
    }

    public Diet saveDiet(Diet diet){
        diet.setOwner(this);
        for (Dishes dish : diet.getDishesList()) {
            dish.setDiet(diet);
        }
        return  diet;
    }

    public Training saveTraining(Training training){
        training.setOwner(this);
        for (Excercise exercise : training.getExcercieses()) {
            exercise.setTraining(training);
        }
        return  training;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", height=" + height +
                ", weight=" + weight +
                ", diets=" + diets +
                ", loginName='" + loginName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", photo='" + photo + '\'' +
                ", authorities=" + authorities +
                ", trainings=" + trainings +
                ", statistics=" + statistics +
                '}';
    }
}

