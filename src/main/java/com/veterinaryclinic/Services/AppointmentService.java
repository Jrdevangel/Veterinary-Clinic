package com.veterinaryclinic.Services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.veterinaryclinic.Controllers.AppointmentController;
import com.veterinaryclinic.Repositories.IAppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    IAppointmentRepository iAppoimentRepository;

    public ArrayList<AppointmentController> getAllAppointments() {
        return iAppoimentRepository.getAllAppointments();
    }

    public ArrayList<AppointmentController> getAppointmentsById() {
        return iAppoimentRepository.getAppointmentsById();
    }

    public ArrayList<AppointmentController> saveAppointments() {
        return iAppoimentRepository.saveAppointments();
    }

    public ArrayList<AppointmentController> updateAppointments() {
        return iAppoimentRepository.updateAppointments();
    }

    public ArrayList<AppointmentController> deleteAppointments() {
        return iAppoimentRepository.deleteAppointments();
    }
    
}