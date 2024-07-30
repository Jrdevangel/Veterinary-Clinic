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

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")

public class PatientsController {

        @Autowired
        PatientsController veterinaryClinicPatients;

        @GetMapping("/patients")
        public ArrayList<PatientsController> getAllPatients() {
                return veterinaryClinicPatients.getAllPatients();
        }

        @GetMapping("/patients/{id}")
        public PatientsController getPatientsById(@PathVariable("id") Long id) {
                return veterinaryClinicPatients.getPatientsById(id);
        }

        @PostMapping(path = "/patients")
        public PatientsController addPatients(@RequestBody PatientsController newPatients) {
                return veterinaryClinicPatients.addPatients(newPatients);
        }

        @PutMapping("/patients/{id}")
        public PatientsController updatePatients(@RequestBody PatientsController newPatients,
                        @PathVariable Long id) {
                return veterinaryClinicPatients.updatePatients(newPatients, id);

        }

        @DeleteMapping("/patients/{id}")
        public PatientsController deletePatients(@PathVariable Long id) {
                return veterinaryClinicPatients.deletePatients(id);

        }

}