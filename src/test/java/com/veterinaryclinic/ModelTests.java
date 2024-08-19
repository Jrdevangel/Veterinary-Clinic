package com.veterinaryclinic;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import com.veterinaryclinic.Models.Appointment;
import com.veterinaryclinic.Models.Patient;

public class ModelTests {

    @Test
    public void testAppointmentSettersAndGetters() {

        Appointment appointment = new Appointment();

        appointment.setDate(LocalDate.of(2024, 1, 1));

        LocalTime time = LocalTime.parse("10:00:00");
        appointment.setTime(time);

        appointment.setEmergency(false);
        appointment.setReason("Checkup");
        appointment.setPast(false);
        appointment.setTreatment("None");

        assertEquals(LocalDate.of(2024, 1, 1), appointment.getDate());
        assertEquals(time, appointment.getTime());
        assertFalse(appointment.isEmergency());
        assertEquals("Checkup", appointment.getReason());
        assertFalse(appointment.isPast());
        assertEquals("None", appointment.getTreatment());
    }

    @Test
    public void testPatientSettersAndGetters() {

        Patient patient = new Patient();

        patient.setName("Fluffy");

        patient.setAge(String.valueOf(5));
        patient.setRace("Siamese");
        patient.setGenre("Female");

        assertEquals("Fluffy", patient.getName());
        assertEquals("5", patient.getAge());
        assertEquals("Siamese", patient.getRace());
        assertEquals("Female", patient.getGenre());
    }
}
