package com.veterinaryclinic.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.veterinaryclinic.Models.Patient;
import com.veterinaryclinic.Repositories.IPatientsRepository;

@Service
public class PatientsService {

    @Autowired
    IPatientsRepository patientsRepository;

    public List<Patient> getAllPatients() {
        return patientsRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientsRepository.findById(id).orElse(null);
    }

    public Patient savePatient(Patient patient) {
        return patientsRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient updatedPatient) {
        if (patientsRepository.existsById(id)) {
            updatedPatient.setId(id);
            return patientsRepository.save(updatedPatient);
        }
        return null;
    }

    public String deletePatient(Long id) {
        try {
            if (patientsRepository.existsById(id)) {
                patientsRepository.deleteById(id);
                return "all ok";
            } else {
                return "patient not found";
            }
        } catch (Exception e) {
            return "error: " + e.getMessage();
        }
    }
}
