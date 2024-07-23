package com.veterinaryclinic.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.veterinaryclinic.Services.VeterinaryClinicServices;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")

public class VeterinaryClinicControllers {

        @Autowired
        VeterinaryClinicServices veterinaryclinicServices;

        @GetMapping("/patients")
        public List<Patient> getAllPatients() {
                return pacienteService.getAllPatients();
        }

        @GetMapping("/patients/{id}")
        public Optional<Patient> getAllPatientsById(@PathVariable Long id) {
                return patientService.getPacienteById(id);
        }
}