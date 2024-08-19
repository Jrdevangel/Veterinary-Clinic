package com.veterinaryclinic.Services;

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

import com.veterinaryclinic.Models.Patient;
import com.veterinaryclinic.Repositories.IPatientsRepository;

public class PatientsServiceTests {

    @InjectMocks
    private PatientsService patientsService;

    @Mock
    private IPatientsRepository patientsRepository;

    private Patient patient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        patient = new Patient();
        patient.setId(1L);
        patient.setName("Fluffy");
        patient.setAge("5");
        patient.setRace("Siamese");
        patient.setGenre("Female");
    }

    @Test
    public void testGetAllPatients() {

        when(patientsRepository.findAll()).thenReturn(Arrays.asList(patient));

        List<Patient> result = patientsService.getAllPatients();

        assertEquals(1, result.size());
        assertEquals("Fluffy", result.get(0).getName());
        verify(patientsRepository, times(1)).findAll();
    }

    @Test
    public void testGetPatientById() {

        when(patientsRepository.findById(1L)).thenReturn(Optional.of(patient));

        Patient result = patientsService.getPatientById(1L);

        assertEquals("Fluffy", result.getName());
        verify(patientsRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetPatientByIdNotFound() {

        when(patientsRepository.findById(1L)).thenReturn(Optional.empty());

        Patient result = patientsService.getPatientById(1L);

        assertNull(result);
        verify(patientsRepository, times(1)).findById(1L);
    }

    @Test
    public void testSavePatient() {

        when(patientsRepository.save(any(Patient.class))).thenReturn(patient);

        Patient result = patientsService.savePatient(patient);

        assertEquals("Fluffy", result.getName());
        verify(patientsRepository, times(1)).save(patient);
    }

    @Test
    public void testUpdatePatient() {

        when(patientsRepository.existsById(1L)).thenReturn(true);
        when(patientsRepository.save(any(Patient.class))).thenReturn(patient);

        Patient result = patientsService.updatePatient(1L, patient);

        assertEquals("Fluffy", result.getName());
        verify(patientsRepository, times(1)).existsById(1L);
        verify(patientsRepository, times(1)).save(patient);
    }

    @Test
    public void testUpdatePatientNotFound() {

        when(patientsRepository.existsById(1L)).thenReturn(false);

        Patient result = patientsService.updatePatient(1L, patient);

        assertNull(result);
        verify(patientsRepository, times(1)).existsById(1L);
        verify(patientsRepository, times(0)).save(any(Patient.class));
    }

    @Test
    public void testDeletePatient() {

        when(patientsRepository.existsById(1L)).thenReturn(true);

        String result = patientsService.deletePatient(1L);

        assertEquals("all ok", result);
        verify(patientsRepository, times(1)).existsById(1L);
        verify(patientsRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeletePatientNotFound() {

        when(patientsRepository.existsById(1L)).thenReturn(false);

        String result = patientsService.deletePatient(1L);

        assertEquals("patient not found", result);
        verify(patientsRepository, times(1)).existsById(1L);
        verify(patientsRepository, times(0)).deleteById(1L);
    }

    @Test
    public void testDeletePatientError() {

        when(patientsRepository.existsById(1L)).thenReturn(true);
        doThrow(new RuntimeException("Database error")).when(patientsRepository).deleteById(anyLong());

        String result = patientsService.deletePatient(1L);

        assertEquals("error: Database error", result);
        verify(patientsRepository, times(1)).existsById(1L);
        verify(patientsRepository, times(1)).deleteById(1L);
    }
}
