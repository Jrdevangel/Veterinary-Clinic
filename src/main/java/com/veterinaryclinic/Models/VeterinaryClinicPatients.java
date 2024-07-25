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

    public void setName(String nameString) {
        this.name = nameString;
    }

    public String getName() {
        return name;
    
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getRace() {
        return race;
    
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    
    }

}
