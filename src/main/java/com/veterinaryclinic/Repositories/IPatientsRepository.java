package com.veterinaryclinic.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaryclinic.Models.Patient;

public interface IPatientsRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByName(String name);
}
