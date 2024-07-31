package com.veterinaryclinic;

import com.veterinaryclinic.Controllers.AppointmentController;
import com.veterinaryclinic.Controllers.PatientsController;
import com.veterinaryclinic.Models.Appointment;
import com.veterinaryclinic.Models.Patient;
import com.veterinaryclinic.Services.AppointmentService;
import com.veterinaryclinic.Services.PatientsService;
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
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest({ AppointmentController.class, PatientsController.class })
public class VeterinaryClinicControllerTests {

	@Mock
	private AppointmentService appointmentService;

	@Mock
	private PatientsService patientsService;

	@InjectMocks
	private AppointmentController appointmentController;

	@InjectMocks
	private PatientsController patientsController;

	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(appointmentController, patientsController).build();
	}

	// Tests for AppointmentController
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
		when(appointmentService.getAppointmentById(anyLong())).thenReturn(Optional.of(appointment));

		mockMvc.perform(get("/appointments/1"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
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
		mockMvc.perform(delete("/appointments/1"))
				.andExpect(status().isOk());
	}

	// Tests for PatientsController
	@Test
	public void testGetAllPatients() throws Exception {
		when(patientsService.getAllPatients()).thenReturn(Collections.singletonList(new Patient()));

		mockMvc.perform(get("/patients"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void testGetPatientById() throws Exception {
		Patient patient = new Patient();
		patient.setId(1L);
		when(patientsService.getPatientById(anyLong())).thenReturn(Optional.of(patient));

		mockMvc.perform(get("/patients/1"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void testAddPatient() throws Exception {
		Patient patient = new Patient();
		when(patientsService.savePatient(any(Patient.class))).thenReturn(patient);

		mockMvc.perform(post("/patients")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\": \"Fluffy\", \"age\": \"5\", \"race\": \"Siamese\", \"genre\": \"Female\"}"))
				.andExpect(status().isOk());
	}

	@Test
	public void testUpdatePatient() throws Exception {
		Patient patient = new Patient();
		patient.setId(1L);
		when(patientsService.updatePatient(anyLong(), any(Patient.class))).thenReturn(patient);

		mockMvc.perform(put("/patients/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\": \"Fluffy\", \"age\": \"5\", \"race\": \"Siamese\", \"genre\": \"Female\"}"))
				.andExpect(status().isOk());
	}

	@Test
	public void testDeletePatient() throws Exception {
		mockMvc.perform(delete("/patients/1"))
				.andExpect(status().isOk());
	}
}
