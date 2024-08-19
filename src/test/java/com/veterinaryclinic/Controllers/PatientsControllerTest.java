package com.veterinaryclinic.Controllers;

import java.util.Arrays;
import java.util.List;

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

import com.veterinaryclinic.Models.Patient;
import com.veterinaryclinic.Services.PatientsService;

@WebMvcTest(PatientsController.class)
@ExtendWith(MockitoExtension.class)
public class PatientsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientsService patientsService;

    @Test
    public void testGetAllPatients() throws Exception {
        Patient patient = new Patient();
        patient.setId(1L);
        patient.setName("Fluffy");
        patient.setAge("5");
        patient.setRace("Siamese");
        patient.setGenre("Female");

        List<Patient> patients = Arrays.asList(patient);

        when(patientsService.getAllPatients()).thenReturn(patients);

        mockMvc.perform(get("/patients/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Fluffy"));

        verify(patientsService, times(1)).getAllPatients();
    }

    @Test
    public void testGetPatientById() throws Exception {
        Patient patient = new Patient();
        patient.setId(1L);
        patient.setName("Fluffy");
        patient.setAge("5");
        patient.setRace("Siamese");
        patient.setGenre("Female");

        when(patientsService.getPatientById(1L)).thenReturn(patient);

        mockMvc.perform(get("/patients/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Fluffy"));

        verify(patientsService, times(1)).getPatientById(1L);
    }

    @Test
    public void testSavePatient() throws Exception {
        Patient patient = new Patient();
        patient.setId(1L);
        patient.setName("Fluffy");
        patient.setAge("5");
        patient.setRace("Siamese");
        patient.setGenre("Female");

        when(patientsService.savePatient(any(Patient.class))).thenReturn(patient);

        mockMvc.perform(post("/patients/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Fluffy\",\"age\":\"5\",\"race\":\"Siamese\",\"genre\":\"Female\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Fluffy"));

        verify(patientsService, times(1)).savePatient(any(Patient.class));
    }

    @Test
    public void testUpdatePatient() throws Exception {
        Patient patient = new Patient();
        patient.setId(1L);
        patient.setName("Fluffy");
        patient.setAge("5");
        patient.setRace("Siamese");
        patient.setGenre("Female");

        when(patientsService.updatePatient(anyLong(), any(Patient.class))).thenReturn(patient);

        mockMvc.perform(put("/patients/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Fluffy\",\"age\":\"5\",\"race\":\"Siamese\",\"genre\":\"Female\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Fluffy"));

        verify(patientsService, times(1)).updatePatient(anyLong(), any(Patient.class));
    }

    @Test
    public void testDeletePatient() throws Exception {
        when(patientsService.deletePatient(1L)).thenReturn("Deleted");

        mockMvc.perform(delete("/patients/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Deleted"));

        verify(patientsService, times(1)).deletePatient(1L);
    }
}
