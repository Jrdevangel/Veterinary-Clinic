package com.veterinaryclinic.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "veterinaryclinic")

public class VeterinaryClinicOwner {

    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "owner's name")
    private String ownername;
    @Column(name = "owner's number")
    private String ownernumber;

}