package com.veterinaryclinic.Controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

public class AppointmentController {

        @Autowired
        AppointmentService appointmentService;

        @GetMapping("/appointments")
        public ArrayList<Appointment> getAllAppointments() {
                return appointmentService.getAllAppointments();
        }

        @GetMapping("/appointments/{id}")
        public ArrayList<Appointment> getAppointmentsById() {
                return appointmentService.getAppointmentsById();
        }

        @PostMapping(path = "/appointments")
        public void saveAppointments(@RequestBody AppointmentController newAppointments) {
                return appointmentService.saveAppointments(newAppointments);

        }

        @PutMapping("/appointments/{id}")
        public void updateAppointments(@RequestBody AppointmentController newAppointments, @PathVariable Long id) {
                return appointmentService.updateAppointments(id);

        }

        @DeleteMapping("/appointments/{id}")
        public void deleteAppointments(@PathVariable("id") Long id) {
                return appointmentService.deleteAppointments(id);

        }

}
