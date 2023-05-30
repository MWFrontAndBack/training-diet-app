package com.example.trainingdietappbackend.repositories;

import com.example.trainingdietappbackend.entities.Excercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcerciserRepository extends JpaRepository<Excercise,Long> {
}
