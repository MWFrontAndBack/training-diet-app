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

    private boolean canManageMeals;

    private boolean canManageExcercise;
    public Admin( String loginName, String email, String password, String photo,boolean canManageUsers,boolean canManageMeals,boolean canManageExcercise) {
        super( loginName, email, password, photo);
        this.canManageUsers = canManageUsers;
        this.canManageMeals = canManageMeals;
        this.canManageExcercise = canManageExcercise;

    }

    public boolean isCanManageUsers() {
        return canManageUsers;
    }
}
