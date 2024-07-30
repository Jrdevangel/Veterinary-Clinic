package com.veterinaryclinic.Services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.veterinaryclinic.Controllers.AppointmentController;
import com.veterinaryclinic.Repositories.IAppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    IAppointmentRepository iappointmentRepository;

    public ArrayList<AppointmentController> getAllAppointments() {
        return iappointmentRepository.getAllAppointments();
    }

    public ArrayList<AppointmentController> getAppointmentsById() {
        return iappointmentRepository.getAppointmentsById();
    }

    public ArrayList<AppointmentController> saveAppointments() {
        return iappointmentRepository.saveAppointments();
    }

    public ArrayList<AppointmentController> updateAppointments() {
        return iappointmentRepository.updateAppointments();
    }

    public ArrayList<AppointmentController> deleteAppointments() {
        return iappointmentRepository.deleteAppointments();
    }

}