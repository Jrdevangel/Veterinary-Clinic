package com.veterinaryclinic.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaryclinic.Models.Appoinment;
import com.veterinaryclinic.Repositories.IAppoimentRepository;

@Service
public class AppointmentService {

    @Autowired
    IAppoimentRepository iAppoimentRepository;

    public List<Appoinment> getAllAppointments() {
        return iAppoimentRepository.findAll();
    }

    public List<AppointmentService> getAppointmentById(Long id) {
        return veterinaryClinicAppointmentsRepository.findById(id);
    }

    public void addAppointment(AppointmentService appointments) {
        veterinaryClinicAppointmentsRepository.save(appointments);
    }

    public AppointmentService updateAppointment(Long id, AppointmentService updatedAppointments) {
        return veterinaryClinicAppointmentsRepository.update(id);
    }

    public void deleteAppointment(Long id) {
        veterinaryClinicAppointmentsRepository.deleteById(id);
    }
}