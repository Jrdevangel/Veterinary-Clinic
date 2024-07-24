package com.veterinaryclinic.Services;

import com.veterinaryclinic.Models.VeterinaryClinicPatients;
import org.springframework.beans.factory.annotation.Autowired;

@Autowired

public class VeterinaryClinicServices {

    public VeterinaryClinicPatients getPatientsById(Long id) {

        public List<Patient> getAllPatient() {
            return (List<Patient>) iPatientRepository.findAll();
        }


        public Patient getById(Long id) {
            Patient patient;
            patient = iPatientRepository.findById(id).orElseThrow();
            return patient;

        }
    }
}
