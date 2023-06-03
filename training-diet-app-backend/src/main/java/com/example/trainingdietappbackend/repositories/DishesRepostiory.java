package com.example.trainingdietappbackend.repositories;

import com.example.trainingdietappbackend.entities.Dishes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishesRepostiory extends JpaRepository<Dishes,Long> {
}
