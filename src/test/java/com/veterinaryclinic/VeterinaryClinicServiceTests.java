package com.veterinaryclinic;

import com.veterinaryclinic.Models.Appointment;
import com.veterinaryclinic.Models.Patient;
import com.veterinaryclinic.Repositories.IAppointmentRepository;
import com.veterinaryclinic.Repositories.IPatientsRepository;
import com.veterinaryclinic.Services.AppointmentService;
import com.veterinaryclinic.Services.PatientsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class VeterinaryClinicServiceTests {

    @Mock
    private IAppointmentRepository appointmentRepository;

    @Mock
    private IPatientsRepository patientsRepository;

    @InjectMocks
    private AppointmentService appointmentService;

    @InjectMocks
    private PatientsService patientsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Tests for AppointmentService
    @Test
    public void testGetAllAppointmentsService() {
        when(appointmentRepository.findAll()).thenReturn(Collections.singletonList(new Appointment()));

        assertFalse(appointmentService.getAllAppointments().isEmpty());
    }

    @Test
    public void testGetAppointmentByIdService() {
        Appointment appointment = new Appointment();
        appointment.setId(1L);
        when(appointmentRepository.findById(anyLong())).thenReturn(Optional.of(appointment));

        Optional<Appointment> result = appointmentService.getAppointmentById(1L);
        assertTrue(result.isPresent());
        assertEquals(appointment, result.get());
    }

    @Test
    public void testSaveAppointmentService() {
        Appointment appointment = new Appointment();
        when(appointmentRepository.save(any(Appointment.class))).thenReturn(appointment);

        assertEquals(appointment, appointmentService.saveAppointment(appointment));
    }

    @Test
    public void testUpdateAppointmentService() {
        Appointment appointment = new Appointment();
        appointment.setId(1L);
        when(appointmentRepository.existsById(anyLong())).thenReturn(true);
        when(appointmentRepository.save(any(Appointment.class))).thenReturn(appointment);

        assertEquals(appointment, appointmentService.updateAppointment(1L, appointment));
    }

    @Test
    public void testDeleteAppointmentService() {
        when(appointmentRepository.existsById(anyLong())).thenReturn(true);

        assertEquals("todo ok", appointmentService.deleteAppointment(1L));
    }

    // Tests for PatientsService
    @Test
    public void testGetAllPatientsService() {
        when(patientsRepository.findAll()).thenReturn(Collections.singletonList(new Patient()));

        assertFalse(patientsService.getAllPatients().isEmpty());
    }

    @Test
    public void testGetPatientByIdService() {
        Patient patient = new Patient();
        patient.setId(1L);
        when(patientsRepository.findById(anyLong())).thenReturn(Optional.of(patient));

        Optional<Patient> result = patientsService.getPatientById(1L);
        assertTrue(result.isPresent());
        assertEquals(patient, result.get());
    }

    @Test
    public void testSavePatientService() {
        Patient patient = new Patient();
        when(patientsRepository.save(any(Patient.class))).thenReturn(patient);

        assertEquals(patient, patientsService.savePatient(patient));
    }

    @Test
    public void testUpdatePatientService() {
        Patient patient = new Patient();
        patient.setId(1L);
        when(patientsRepository.existsById(anyLong())).thenReturn(true);
        when(patientsRepository.save(any(Patient.class))).thenReturn(patient);

        assertEquals(patient, patientsService.updatePatient(1L, patient));
    }

    @Test
    public void testDeletePatientService() {
        when(patientsRepository.existsById(anyLong())).thenReturn(true);

        assertEquals("todo ok", patientsService.deletePatient(1L));
    }
}
