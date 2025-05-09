package com.example.crimemanagement.repository;

import com.example.crimemanagement.entity.Crime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrimeRepository extends JpaRepository<Crime, Long> {
}
