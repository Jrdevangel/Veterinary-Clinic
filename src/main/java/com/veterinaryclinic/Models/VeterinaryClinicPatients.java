package com.veterinaryclinic.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "veterinaryclinic")

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

    public void getName(String nameString) {
        this.name = nameString;
    }

    public String setName() {
        return name;
    
    }

    public void getAge(String age) {
        this.age = age;
    }

    public String setAge() {
        return age;
    
    }

    public void getRace(String race) {
        this.race = race;
    }

    public String setRace() {
        return race;
    
    }

    public void getGenre(String genre) {
        this.genre = genre;
    }

    public String setGenre() {
        return genre;
    
    }

    public void getId(Long id) {
        this.id = id;
    }

    public Long setId() {
        return id;
    
    }

}
