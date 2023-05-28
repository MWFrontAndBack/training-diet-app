package com.example.trainingdietappbackend.repositories;


import com.example.trainingdietappbackend.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authority,Long> {
}
