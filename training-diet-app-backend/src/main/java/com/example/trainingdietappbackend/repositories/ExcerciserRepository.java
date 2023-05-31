package com.example.trainingdietappbackend.repositories;

import com.example.trainingdietappbackend.entities.Excercise;
import com.example.trainingdietappbackend.entities.User;
import com.example.trainingdietappbackend.entities.enums.TrainingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExcerciserRepository extends JpaRepository<Excercise,Long> {
    @Query("SELECT n FROM Excercise n WHERE n.trainingType= :type")
    List<Excercise> findFOURWithTrainingType(TrainingType type);

    @Query("SELECT n FROM Excercise n WHERE n.id<> :id and n.trainingType= :type")
    List<Excercise> findDifferentTwo(Long id,TrainingType type);
}
