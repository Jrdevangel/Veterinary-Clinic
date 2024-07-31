package com.veterinaryclinic;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import com.veterinaryclinic.Models.Appointment;
import com.veterinaryclinic.Models.Patient;

public class VeterinaryClinicModelTests {

    @Test
    public void testAppointmentSettersAndGetters() {
        // Creating an instance of Appointment
        Appointment appointment = new Appointment();

        // Setting properties
        appointment.setDate(LocalDate.of(2024, 1, 1));

        // Convert string to LocalTime
        LocalTime time = LocalTime.parse("10:00:00");
        appointment.setTime(time);

        appointment.setEmergency(false);
        appointment.setReason("Checkup");
        appointment.setPast(false);
        appointment.setTreatment("None");

        // Getting properties and verifying
        assertEquals(LocalDate.of(2024, 1, 1), appointment.getDate());
        assertEquals(time, appointment.getTime());
        assertFalse(appointment.isEmergency());
        assertEquals("Checkup", appointment.getReason());
        assertFalse(appointment.isPast());
        assertEquals("None", appointment.getTreatment());
    }

    @Test
    public void testPatientSettersAndGetters() {
        // Creating an instance of Patient
        Patient patient = new Patient();

        // Setting properties
        patient.setName("Fluffy");

        // Convert int to String
        patient.setAge(String.valueOf(5));
        patient.setRace("Siamese");
        patient.setGenre("Female");

        // Getting properties and verifying
        assertEquals("Fluffy", patient.getName());
        assertEquals("5", patient.getAge()); // Age is expected to be a String
        assertEquals("Siamese", patient.getRace());
        assertEquals("Female", patient.getGenre());
    }
}
