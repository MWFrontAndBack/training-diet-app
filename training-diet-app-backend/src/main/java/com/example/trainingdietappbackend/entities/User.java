package com.example.trainingdietappbackend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

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

    @JsonManagedReference
    @OneToMany(mappedBy = "owner", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Note> noteList = new ArrayList<>();
    private String loginName;

    @JsonProperty("email")

    private String email;


    @JsonProperty("password")

    private String password;

    private String photo;

    @JsonManagedReference

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Authority> authorities = new HashSet<>();

    // Getters and Setters


    public User(List<Note> noteList, String loginName, String email, String password, String photo, Set<Authority> authorities) {
        this.noteList = noteList;
        this.loginName = loginName;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.authorities = authorities;
    }

    public User(List<Note> noteList, String loginName, String email, String password, String photo) {
        this.noteList = noteList;
        this.loginName = loginName;
        this.email = email;
        this.password = password;
        this.photo = photo;
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", noteList=" + noteList +
                ", loginName='" + loginName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", photo='" + photo + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}

