package com.veterinaryclinic.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.veterinaryclinic.Controllers.AppointmentController;

public interface IAppointmentRepository extends JpaRepository<AppointmentController, Long> {

}