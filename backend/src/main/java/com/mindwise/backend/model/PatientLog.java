package com.mindwise.backend.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class PatientLog
{
    @Id
    @GeneratedValue
    private Long logID;
    private Long patientID;
    private Long doctorID;
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp timestamp;

    public PatientLog() {
    }

    public PatientLog(Long patientID, Long doctorID, String description, Timestamp timestamp) {
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.description = description;
        this.timestamp = timestamp;
    }

    public Long getLogID() {
        return logID;
    }

    public void setLogID(Long logID) {
        this.logID = logID;
    }

    public Long getPatientID() {
        return patientID;
    }

    public void setPatientID(Long patientID) {
        this.patientID = patientID;
    }

    public Long getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Long doctorID) {
        this.doctorID = doctorID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
