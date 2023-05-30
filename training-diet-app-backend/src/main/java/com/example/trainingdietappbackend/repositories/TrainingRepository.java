package com.example.trainingdietappbackend.repositories;

import com.example.trainingdietappbackend.entities.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<Training,Long> {
}
