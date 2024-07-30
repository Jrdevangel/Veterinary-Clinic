package com.veterinaryclinic.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.veterinaryclinic.Controllers.PatientsController;

public interface IPatientsRepository extends JpaRepository<PatientsController, Long> {

}