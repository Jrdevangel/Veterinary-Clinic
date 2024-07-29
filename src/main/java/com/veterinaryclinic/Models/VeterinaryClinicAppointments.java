package com.veterinaryclinic.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "veterinaryclinic")

public class VeterinaryClinicAppointments {

    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "date of appointment")
    private String date;
    @Column(name = "appointment time")
    private String time;
    @Column(name = "patient name")
    private String patient;
    @Column(name = "standard consultation")
    private String standardconsultation;
    @Column(name = "emergency consultation")
    private String emergencyconsultation;
    @Column(name = "reason for appointment")
    private String reason;
    @Column(name = "pending appointment")
    private String pendingappointments;
    @Column(name = "past appointment")
    private String pastappointments;
    @Column(name = "cancel appointment")
    private String cancelappointments;

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;

    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;

    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getPatient() {
        return patient;

    }

    public void setStandarConsultation(String standardconsultation) {
        this.standardconsultation = standardconsultation;
    }

    public String getStandardConsultation() {
        return standardconsultation;

    }

    public void setEmergencyConsultation(String emergencyconsultation) {
        this.emergencyconsultation = emergencyconsultation;
    }

    public String getEmergencyConsultation() {
        return emergencyconsultation;

    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;

    }

    public void setPendingAppointments(String pendingappointments) {
        this.pendingappointments = pendingappointments;
    }

    public String getPendingAppointments() {
        return pendingappointments;

    }

    public void setPastAppointments(String pastappointments) {
        this.pastappointments = pastappointments;
    }

    public String getPastAppointments() {
        return pastappointments;

    }

    public void setCancelAppointments(String cancelappointments) {
        this.cancelappointments = cancelappointments;
    }

    public String getCancelAppointments() {
        return cancelappointments;

    }

}
