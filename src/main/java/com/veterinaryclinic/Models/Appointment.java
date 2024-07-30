package com.veterinaryclinic.Models;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "veterinaryclinic")

public class Appointment {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Date")
    private LocalDate date;

    @Column(name = "Time")
    private LocalTime time;

    @Column(name = "Emergency consultation")
    private boolean emergency;

    @Column(name = "Reason for appointment")
    private String reason;  

    @Column(name = "Appointment status")
    private boolean past;
  
    @Column(name = "treatment")
    private String treatment;

}
