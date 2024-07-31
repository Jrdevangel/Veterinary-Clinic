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
@RequestMapping("/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController {

        @Autowired
        AppointmentService appointmentService;

        @GetMapping("/appointment/")
        public List<Appointment> getAllAppointments() {
                return appointmentService.getAllAppointments();
        }

        @GetMapping("/appointment/{id}")
        public Appointment getAppointmentById(@PathVariable Long id) {
                return appointmentService.getAppointmentById(id);
        }

        @PostMapping("/appointment/")
        public Appointment saveAppointment(@RequestBody Appointment appointment) {
                return appointmentService.saveAppointment(appointment);
        }

        @PutMapping(path = "/appointment/{id}")
        public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment updatedAppointment) {
                return appointmentService.updateAppointment(id, updatedAppointment);
        }

        @DeleteMapping("/appointment/{id}")
        public String deleteAppointment(@PathVariable Long id) {
                return appointmentService.deleteAppointment(id);
        }
}
