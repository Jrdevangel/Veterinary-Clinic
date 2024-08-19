package com.veterinaryclinic.Controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.veterinaryclinic.Models.Appointment;
import com.veterinaryclinic.Services.AppointmentService;

@WebMvcTest(AppointmentController.class)
@ExtendWith(MockitoExtension.class)
public class AppointmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppointmentService appointmentService;

    @Test
    public void testGetAllAppointments() throws Exception {
        Appointment appointment = new Appointment();
        appointment.setId(1L);
        appointment.setDate(LocalDate.of(2024, 1, 1));
        appointment.setTime(LocalTime.of(10, 0));
        appointment.setReason("Checkup");

        List<Appointment> appointments = Arrays.asList(appointment);

        when(appointmentService.getAllAppointments()).thenReturn(appointments);

        mockMvc.perform(get("/appointments/appointment/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].reason", is("Checkup")));

        verify(appointmentService, times(1)).getAllAppointments();
    }

    @Test
    public void testGetAppointmentById() throws Exception {
        Appointment appointment = new Appointment();
        appointment.setId(1L);
        appointment.setDate(LocalDate.of(2024, 1, 1));
        appointment.setTime(LocalTime.of(10, 0));
        appointment.setReason("Checkup");

        when(appointmentService.getAppointmentById(1L)).thenReturn(appointment);

        mockMvc.perform(get("/appointments/appointment/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.reason", is("Checkup")));

        verify(appointmentService, times(1)).getAppointmentById(1L);
    }

    @Test
    public void testSaveAppointment() throws Exception {
        Appointment appointment = new Appointment();
        appointment.setId(1L);
        appointment.setDate(LocalDate.of(2024, 1, 1));
        appointment.setTime(LocalTime.of(10, 0));
        appointment.setReason("Checkup");

        when(appointmentService.saveAppointment(any(Appointment.class))).thenReturn(appointment);

        mockMvc.perform(post("/appointments/appointment/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"date\":\"2024-01-01\",\"time\":\"10:00:00\",\"reason\":\"Checkup\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.reason", is("Checkup")));

        verify(appointmentService, times(1)).saveAppointment(any(Appointment.class));
    }

    @Test
    public void testUpdateAppointment() throws Exception {
        Appointment appointment = new Appointment();
        appointment.setId(1L);
        appointment.setDate(LocalDate.of(2024, 1, 1));
        appointment.setTime(LocalTime.of(10, 0));
        appointment.setReason("Checkup");

        when(appointmentService.updateAppointment(anyLong(), any(Appointment.class))).thenReturn(appointment);

        mockMvc.perform(put("/appointments/appointment/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"date\":\"2024-01-01\",\"time\":\"10:00:00\",\"reason\":\"Checkup\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.reason", is("Checkup")));

        verify(appointmentService, times(1)).updateAppointment(anyLong(), any(Appointment.class));
    }

    @Test
    public void testDeleteAppointment() throws Exception {
        when(appointmentService.deleteAppointment(1L)).thenReturn("Deleted");

        mockMvc.perform(delete("/appointments/appointment/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Deleted"));

        verify(appointmentService, times(1)).deleteAppointment(1L);
    }
}
