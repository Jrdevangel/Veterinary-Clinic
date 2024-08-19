package com.veterinaryclinic.Services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.veterinaryclinic.Models.Appointment;
import com.veterinaryclinic.Repositories.IAppointmentRepository;

public class AppointmentServiceTests {

    @InjectMocks
    private AppointmentService appointmentService;

    @Mock
    private IAppointmentRepository appointmentRepository;

    private Appointment appointment;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        appointment = new Appointment();
        appointment.setId(1L);
        appointment.setDate(LocalDate.of(2024, 1, 1));
        appointment.setTime(LocalTime.of(10, 0));
        appointment.setReason("Checkup");
    }

    @Test
    public void testGetAllAppointments() {
        when(appointmentRepository.findAll()).thenReturn(Arrays.asList(appointment));

        List<Appointment> result = appointmentService.getAllAppointments();

        assertEquals(1, result.size());
        assertEquals("Checkup", result.get(0).getReason());
        verify(appointmentRepository, times(1)).findAll();
    }

    @Test
    public void testGetAppointmentById() {
        when(appointmentRepository.findById(1L)).thenReturn(Optional.of(appointment));

        Appointment result = appointmentService.getAppointmentById(1L);

        assertEquals("Checkup", result.getReason());
        verify(appointmentRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetAppointmentByIdNotFound() {
        when(appointmentRepository.findById(1L)).thenReturn(Optional.empty());

        Appointment result = appointmentService.getAppointmentById(1L);

        assertNull(result);
        verify(appointmentRepository, times(1)).findById(1L);
    }

    @Test
    public void testSaveAppointment() {
        when(appointmentRepository.save(any(Appointment.class))).thenReturn(appointment);

        Appointment result = appointmentService.saveAppointment(appointment);

        assertEquals("Checkup", result.getReason());
        verify(appointmentRepository, times(1)).save(appointment);
    }

    @Test
    public void testUpdateAppointment() {
        when(appointmentRepository.existsById(1L)).thenReturn(true);
        when(appointmentRepository.save(any(Appointment.class))).thenReturn(appointment);

        Appointment result = appointmentService.updateAppointment(1L, appointment);

        assertEquals("Checkup", result.getReason());
        verify(appointmentRepository, times(1)).existsById(1L);
        verify(appointmentRepository, times(1)).save(appointment);
    }

    @Test
    public void testUpdateAppointmentNotFound() {
        when(appointmentRepository.existsById(1L)).thenReturn(false);

        Appointment result = appointmentService.updateAppointment(1L, appointment);

        assertNull(result);
        verify(appointmentRepository, times(1)).existsById(1L);
        verify(appointmentRepository, times(0)).save(any(Appointment.class));
    }

    @Test
    public void testDeleteAppointment() {
        when(appointmentRepository.existsById(1L)).thenReturn(true);

        String result = appointmentService.deleteAppointment(1L);

        assertEquals("all ok", result);
        verify(appointmentRepository, times(1)).existsById(1L);
        verify(appointmentRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeleteAppointmentNotFound() {
        when(appointmentRepository.existsById(1L)).thenReturn(false);

        String result = appointmentService.deleteAppointment(1L);

        assertEquals("appointment not found", result);
        verify(appointmentRepository, times(1)).existsById(1L);
        verify(appointmentRepository, times(0)).deleteById(1L);
    }

    @Test
    public void testDeleteAppointmentError() {
        when(appointmentRepository.existsById(1L)).thenReturn(true);
        doThrow(new RuntimeException("Database error")).when(appointmentRepository).deleteById(anyLong());

        String result = appointmentService.deleteAppointment(1L);

        assertEquals("error: Database error", result);
        verify(appointmentRepository, times(1)).existsById(1L);
        verify(appointmentRepository, times(1)).deleteById(1L);
    }
}
