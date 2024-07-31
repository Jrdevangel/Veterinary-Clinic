package com.veterinaryclinic;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.veterinaryclinic.Models.Appointment;
import com.veterinaryclinic.Models.Patient;
import com.veterinaryclinic.Repositories.IAppointmentRepository;
import com.veterinaryclinic.Repositories.IPatientsRepository;

@DataJpaTest
public class RepositoryTests {

    @Autowired
    private IAppointmentRepository appointmentRepository;

    @Autowired
    private IPatientsRepository patientsRepository;

   
    @Test
    public void testFindByDate() {
        Appointment appointment = new Appointment();
        appointment.setDate(LocalDate.now());
        appointmentRepository.save(appointment);

        List<Appointment> appointments = appointmentRepository.findByDate(LocalDate.now());

        assertFalse(appointments.isEmpty());
    }

    
    @Test
    public void testFindById() {
        Patient patient = new Patient();
        patient.setName("Fluffy");
        patientsRepository.save(patient);

        Optional<Patient> found = patientsRepository.findById(patient.getId());

        assertTrue(found.isPresent());
        assertEquals("Fluffy", found.get().getName());
    }
}
