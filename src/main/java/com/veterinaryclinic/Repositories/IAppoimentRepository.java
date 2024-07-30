package com.veterinaryclinic.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaryclinic.Models.Appoinment;

public interface IAppoimentRepository extends JpaRepository<Appoinment, Long> {

}