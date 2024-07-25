package com.veterinaryclinic.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "veterinaryclinic")

public class VeterinaryClinicTreatments {

    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "id")
    private Long id;

    public void setName(String nameString) {
        this.name = nameString;
    }

    public String getName() {
        return name;
    
    }

    public void setType(String typeString) {
        this.type = typeString;
    }

    public String getType() {
        return type;
    
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    
    }
}
