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

import com.veterinaryclinic.Models.Appoinment;
import com.veterinaryclinic.Services.AppointmentService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")

public class AppoimentController {

        @Autowired
        AppointmentService appointmentService;

        @GetMapping("/appointments")
        public List<Appoinment> getALL() {
                return appointmentService.getAllAppointments();
        }

        @PostMapping(path = "/appointments")
        public void seethelistofAppointments(@RequestBody AppoimentController newAppointments) {
                veterinaryClinicAppointments.seethelistofAppointments(newAppointments);

        }

        @PutMapping("/appointments/{id}")
        public AppoimentController updateAppointments(@RequestBody AppoimentController newAppointments,
                        @PathVariable Long id) {
                return veterinaryClinicAppointments.updateAppointments(newAppointments, id);

        }

        @DeleteMapping("/appointments/{id}")
        public AppoimentController deleteAppointments(@PathVariable("id") Long id) {
                return veterinaryClinicAppointments.deleteAppointments(id);

        }

}
