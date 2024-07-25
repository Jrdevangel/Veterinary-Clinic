package com.veterinaryclinic.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.veterinaryclinic.Models.VeterinaryClinicPatients;
import com.veterinaryclinic.Services.VeterinaryClinicServices;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")

public class VeterinaryClinicControllers {

        @Autowired
        VeterinaryClinicServices veterinaryclinicServices;

        @GetMapping("/patients")
        public ArrayList<VeterinaryClinicPatients> getAllPatients() {
                return veterinaryclinicServices.getAllPatients();
        }

        @GetMapping("/patients/{id}")
        public VeterinaryClinicPatients getAllPatientsById(@PathVariable("id") Long id) {
                return veterinaryclinicServices.getPatientsById(id);
        }

        @PostMapping(path = "/veterinary")
        public VeterinaryClinicPatients addPatients(@RequestBody VeterinaryClinicPatients newPatients) {
                return veterinaryclinicServices.savePatients(newPatients);
        }

        @PutMapping("/patients/{id}")
        public VeterinaryClinicPatients updatePatients(@PathVariable Long id,
                        @RequestBody VeterinaryClinicPatients patientsDetails) {
                return veterinaryclinicServices.updatePatients(id, patientsDetails);

        }

        @DeleteMapping("/pacientes/{id}")
        public VeterinaryClinicPatients deletePaciente(@PathVariable Long id,
                        @RequestBody VeterinaryClinicPatients patientsDetails) {
                return veterinaryclinicServices.deletePatients(id, patientsDetails);

        }

}
