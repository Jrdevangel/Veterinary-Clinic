package com.veterinaryclinic.Controllers;

import com.veterinaryclinic.Models.VeterinaryClinicPatients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.veterinaryclinic.Services.VeterinaryClinicServices;

import java.util.ArrayList;

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
}