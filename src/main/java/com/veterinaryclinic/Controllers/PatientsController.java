package com.veterinaryclinic.Controllers;

import java.util.List;

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

import com.veterinaryclinic.Models.Patient;
import com.veterinaryclinic.Services.PatientsService;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "*")
public class PatientsController {

        @Autowired
        PatientsService patientsService;

        @GetMapping("/")
        public List<Patient> getAllPatients() {
                return patientsService.getAllPatients();
        }

        @GetMapping("/{id}")
        public Patient getPatientById(@PathVariable Long id) {
                return patientsService.getPatientById(id);
        }

        @PostMapping("/")
        public Patient savePatient(@RequestBody Patient patient) {
                return patientsService.savePatient(patient);
        }

        @PutMapping("/{id}")
        public Patient updatePatient(@PathVariable Long id, @RequestBody Patient updatedPatient) {
                return patientsService.updatePatient(id, updatedPatient);
        }

        @DeleteMapping("/{id}")
        public String deletePatient(@PathVariable Long id) {
                return patientsService.deletePatient(id);
        }
}
