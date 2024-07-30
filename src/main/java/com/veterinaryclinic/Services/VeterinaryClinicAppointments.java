package com.veterinaryclinic.Services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.veterinaryclinic.Repositories.IveterinaryClinicAppointmentsRepository;

@Service
public class VeterinaryClinicAppointments {

    @Autowired
    IveterinaryClinicAppointmentsRepository veterinaryClinicAppointmentsRepository;

    public ArrayList<VeterinaryClinicAppointments> getAllAppointments() {
        return veterinaryClinicAppointmentsRepository.findAll();
    }

    public ArrayList<VeterinaryClinicAppointments> getAppointmentById(Long id) {
        return veterinaryClinicAppointmentsRepository.findById(id);
    }

    public VeterinaryClinicAppointments addAppointment(VeterinaryClinicAppointments appointments) {
        return veterinaryClinicAppointmentsRepository.save();
    }

    public VeterinaryClinicAppointments updateAppointment(Long id, VeterinaryClinicAppointments updatedAppointments) {
        return veterinaryClinicAppointmentsRepository.update(id);
    }

    public void deleteAppointment(Long id) {
        veterinaryClinicAppointmentsRepository.deleteById(id);
    }
}