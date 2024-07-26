package com.veterinaryclinic.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.veterinaryclinic.Models.VeterinaryClinicPatients;

public interface iveterinaryClinicRepository extends JpaRepository<VeterinaryClinicPatients, Long>  {
    
}