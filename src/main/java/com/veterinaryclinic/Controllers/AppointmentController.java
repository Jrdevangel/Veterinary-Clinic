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

import com.veterinaryclinic.Models.Appointment;
import com.veterinaryclinic.Services.AppointmentService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")

public class AppoimentController {

        @Autowired
        AppointmentService appointmentService;

        @GetMapping("/appointments")
        public List<Appointment> getAllAppointments() {
                return appointmentService.getAllAppointments();
        }

        @GetMapping("/appointments/{id}")
        public List<Appointment> getAppointmentsById() {
                return appointmentService.getAppointmentsById();
        }

        @PostMapping(path = "/appointments")
        public void saveAppointments(@RequestBody AppoimentController newAppointments) {
                return appointmentService.saveAppointments(newAppointments);

        }

        @PutMapping("/appointments/{id}")
        public void updateAppointments(@RequestBody AppoimentController newAppointments, @PathVariable Long id) {
                return appointmentService.updateAppointments(newAppointments, id);

        }

        @DeleteMapping("/appointments/{id}")
        public void deleteAppointments(@PathVariable("id") Long id) {
                return appointmentService.deleteAppointments(id);

        }

}
