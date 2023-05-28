package com.example.trainingdietappbackend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "admin")
@Getter
@Setter
@NoArgsConstructor

public class Admin extends User{
    @Column(name = "canmanage")
    private  boolean canManageUsers;

    public Admin(List<Note> noteList, String loginName, String email, String password, String photo,boolean canManageUsers) {
        super(noteList, loginName, email, password, photo);
        this.canManageUsers = canManageUsers;

    }

    public boolean isCanManageUsers() {
        return canManageUsers;
    }
}
