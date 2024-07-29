package com.veterinaryclinic.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.veterinaryclinic.Repositories.IveterinaryClinicAppointmentsRepository;

@Service
public class VeterinaryClinicAppointments {

    @Autowired
    IveterinaryClinicAppointmentsRepository veterinaryClinicAppointmentsRepository;
}