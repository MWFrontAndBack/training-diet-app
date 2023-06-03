package com.example.trainingdietappbackend.repositories;

import com.example.trainingdietappbackend.entities.Diet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietRepository extends JpaRepository<Diet,Long> {
}
