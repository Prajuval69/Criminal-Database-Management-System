package com.example.crimemanagement.service;

import com.example.crimemanagement.entity.Crime;
import com.example.crimemanagement.repository.CrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrimeService {

    @Autowired
    private CrimeRepository crimeRepository;

    public List<Crime> getAllCrimes() {
        return crimeRepository.findAll();
    }

    public Crime getCrimeById(Long id) {
        return crimeRepository.findById(id).orElse(null);
    }

    public void saveCrime(Crime crime) {
        crimeRepository.save(crime);
    }

    public void deleteCrime(Long id) {
        crimeRepository.deleteById(id);
    }
}
