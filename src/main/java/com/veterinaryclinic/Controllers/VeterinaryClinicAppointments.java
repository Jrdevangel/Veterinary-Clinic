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

public class VeterinaryClinicAppointments {

        @Autowired
        VeterinaryClinicAppointments veterinaryClinicAppointments;

        @GetMapping("/appointments")
        public ArrayList<VeterinaryClinicAppointments> manageAppointments() {
                return veterinaryClinicAppointments.manageAppointments();
        }

        @PostMapping(path = "/appointments")
        public VeterinaryClinicAppointments seethelistofAppointments(@RequestBody VeterinaryClinicAppointments newAppointments) {
                return veterinaryClinicAppointments.seethelistofAppointments(newAppointments);
        }

        @PutMapping("/appointments/{id}")
        public VeterinaryClinicAppointments updateAppointments(@RequestBody VeterinaryClinicAppointments newAppointments, @PathVariable Long id) {
                return veterinaryClinicAppointments.updateAppointments(id);

        }

        @DeleteMapping("/appointments/{id}")
        public VeterinaryClinicAppointments deleteAppointments(@PathVariable("id") Long id) {
                return veterinaryClinicAppointments.deleteAppointments(id);

        }
       
}
