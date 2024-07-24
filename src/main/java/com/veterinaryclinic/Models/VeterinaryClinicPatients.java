package com.veterinaryclinic.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "veterinaryClinic")

public class VeterinaryClinicPatients {

    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private String age;
    @Column(name = "race")
    private String race;
    @Column(name = "genre")
    private String genre;
    @Column(name = "id")
    private Long id;
}
