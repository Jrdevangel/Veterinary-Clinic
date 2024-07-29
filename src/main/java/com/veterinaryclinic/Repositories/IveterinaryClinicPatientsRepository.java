package com.veterinaryclinic.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.veterinaryclinic.Controllers.VeterinaryClinicAppointments;

public interface IveterinaryClinicPatientsRepository extends JpaRepository<VeterinaryClinicAppointments, String> {
    
}