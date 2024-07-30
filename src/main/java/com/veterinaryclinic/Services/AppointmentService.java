package com.veterinaryclinic.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.veterinaryclinic.Repositories.IAppoimentRepository;

@Service
public class AppointmentService {

    @Autowired
    IAppoimentRepository iAppoimentRepository;

}