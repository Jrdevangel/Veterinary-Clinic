package com.veterinaryclinic;

import com.veterinaryclinic.Controllers.AppointmentController;
import com.veterinaryclinic.Models.Appointment;
import com.veterinaryclinic.Services.AppointmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AppointmentController.class)
public class AppointmentControllerTests {

	@Mock
	private AppointmentService appointmentService;

	@InjectMocks
	private AppointmentController appointmentController;

	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(appointmentController).build();
	}
	
	@Test
	public void testGetAllAppointments() throws Exception {
		when(appointmentService.getAllAppointments()).thenReturn(Collections.singletonList(new Appointment()));

		mockMvc.perform(get("/appointments"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void testGetAppointmentById() throws Exception {
		Appointment appointment = new Appointment();
		appointment.setId(1L);
		when(appointmentService.getAppointmentById(anyLong())).thenReturn(appointment);

		mockMvc.perform(get("/appointments/1"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id").value(1L));
	}

	@Test
	public void testSaveAppointment() throws Exception {
		Appointment appointment = new Appointment();
		when(appointmentService.saveAppointment(any(Appointment.class))).thenReturn(appointment);

		mockMvc.perform(post("/appointments")
				.contentType(MediaType.APPLICATION_JSON)
				.content(
						"{\"date\": \"2024-01-01\", \"time\": \"10:00:00\", \"emergency\": false, \"reason\": \"Checkup\", \"past\": false, \"treatment\": \"None\"}"))
				.andExpect(status().isOk());
	}

	@Test
	public void testUpdateAppointment() throws Exception {
		Appointment appointment = new Appointment();
		appointment.setId(1L);
		when(appointmentService.updateAppointment(anyLong(), any(Appointment.class))).thenReturn(appointment);

		mockMvc.perform(put("/appointments/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(
						"{\"date\": \"2024-01-01\", \"time\": \"10:00:00\", \"emergency\": false, \"reason\": \"Checkup\", \"past\": false, \"treatment\": \"None\"}"))
				.andExpect(status().isOk());
	}

	@Test
	public void testDeleteAppointment() throws Exception {
		when(appointmentService.deleteAppointment(anyLong())).thenReturn("all ok");

		mockMvc.perform(delete("/appointments/1"))
				.andExpect(status().isOk());
	}
}