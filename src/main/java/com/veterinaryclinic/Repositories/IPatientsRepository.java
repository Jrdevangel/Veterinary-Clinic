package com.veterinaryclinic.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.veterinaryclinic.Controllers.AppoimentController;

public interface IveterinaryClinicPatientsRepository extends JpaRepository<AppoimentController, String> {

}