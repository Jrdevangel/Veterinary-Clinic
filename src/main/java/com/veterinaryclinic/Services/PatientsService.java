package com.veterinaryclinic.Services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.veterinaryclinic.Controllers.AppointmentController;
import com.veterinaryclinic.Controllers.PatientsController;
import com.veterinaryclinic.Repositories.IPatientsRepository;

@Service
public class PatientsService {

    @Autowired
    IPatientsRepository patientsRepository;

    public ArrayList<PatientsController> getAllPatients() {
        return patientsRepository.getAllPatients();
    }

    public ArrayList<PatientsController> getPatientsById(Long id) {
        return patientsRepository.getPatientsById();
    }

    public PatientsController savePatients(PatientsController patients) {
        return patientsRepository.savePatients();
    }

    public void updatePatients(PatientsController patients) {
        return patientsRepository.updatePatients();
    }

    public String deletePatients(Long id) {
        try{
            patientsRepository.deleteById(id);
            return "todo ok";
        } catch (Exception error){
        return "todo mal"; }
    }

    }
