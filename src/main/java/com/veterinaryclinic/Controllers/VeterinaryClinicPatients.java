package com.veterinaryclinic.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaryclinic.Services.VeterinaryClinicServices;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")

public class VeterinaryClinicPatients {

        @Autowired
        VeterinaryClinicPatients veterinaryclinicPatients;

        @GetMapping("/patients")
        public ArrayList<VeterinaryClinicPatients> getAllPatients() {
                return veterinaryclinicPatients.getAllPatients();
        }

        @GetMapping("/patients/{id}")
        public VeterinaryClinicPatients getPatientsById(@PathVariable("id") Long id) {
                return veterinaryclinicPatients.getPatientsById(id);
        }

        @PostMapping(path = "/patients")
        public VeterinaryClinicPatients addPatients(@RequestBody VeterinaryClinicPatients newPatients) {
                return veterinaryclinicPatients.addPatients(newPatients);
        }

        @PutMapping("/patients/{id}")
        public VeterinaryClinicPatients updatePatients(@RequestBody VeterinaryClinicPatients newPatients, @PathVariable Long id) {
                newPatients.setId(id); 
                return veterinaryclinicPatients.updatePatients(id);

        }

        @DeleteMapping("/patients/{id}")
        public VeterinaryClinicPatients deletePatients(@PathVariable Long id, @RequestBody VeterinaryClinicPatients patientsDetails) {
                return veterinaryclinicPatients.deletePatients(id, patientsDetails);

        }


    
}
