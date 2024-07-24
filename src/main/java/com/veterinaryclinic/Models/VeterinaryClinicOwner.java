package com.veterinaryclinic.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "veterinaryClinic")

public class VeterinaryClinicOwner {


    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "owner's name")
    private String ownerName;
    @Column(name = "owner's number")
    private String ownerNumber;

}