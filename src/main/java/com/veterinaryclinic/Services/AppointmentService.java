package com.veterinaryclinic.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaryclinic.Models.Appointment;
import com.veterinaryclinic.Repositories.IAppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    IAppointmentRepository iAppointmentRepository;

    public List<Appointment> getAllAppointments() {
        return iAppointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long id) {
        return iAppointmentRepository.findById(id).orElse(null);
    }

    public Appointment saveAppointment(Appointment appointment) {
        return iAppointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        if (iAppointmentRepository.existsById(id)) {
            updatedAppointment.setId(id);
            return iAppointmentRepository.save(updatedAppointment);
        }
        return null;
    }

    public String deleteAppointment(Long id) {
        try {
            if (iAppointmentRepository.existsById(id)) {
                iAppointmentRepository.deleteById(id);
                return "all ok";
            } else {
                return "appointment not found";
            }
        } catch (Exception e) {
            return "error: " + e.getMessage();
        }
    }
}
