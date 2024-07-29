package com.veterinaryclinic.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.veterinaryclinic.Controllers.VeterinaryClinicAppointments;

public interface IveterinaryClinicAppointmentsRepository extends JpaRepository<VeterinaryClinicAppointments, String> {
 
}