package com.veterinaryclinic;

import com.veterinaryclinic.Controllers.PatientsController;
import com.veterinaryclinic.Models.Patient;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PatientsController.class)
public class PatientsControllerTests {

    @Mock
    private PatientsService patientsService;

    @InjectMocks
    private PatientsController patientsController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(patientsController).build();
    }

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
        when(patientsService.getPatientById(anyLong())).thenReturn(patient);

        mockMvc.perform(get("/patients/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L));
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
        when(patientsService.deletePatient(anyLong())).thenReturn("all ok");

        mockMvc.perform(delete("/patients/1"))
                .andExpect(status().isOk());
    }
}
