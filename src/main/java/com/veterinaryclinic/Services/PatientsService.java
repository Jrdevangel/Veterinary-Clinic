package com.veterinaryclinic.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.veterinaryclinic.Repositories.IPatientsRepository;

@Service
public class VeterinaryClinicPatients {

    @Autowired
    IPatientsRepository veterinaryClinicPatientsRepository;

}
