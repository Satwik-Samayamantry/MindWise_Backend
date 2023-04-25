package com.mindwise.backend.model;
import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity
public class Notifications {

    public Long getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(Long notificationID) {
        this.notificationID = notificationID;
    }

    @Id
    @GeneratedValue
    private Long notificationID;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp timestamp;

    private Long doctorID;
    private Long patientID;

    public Notifications() {

    }

    public Notifications(String description,Timestamp timestamp, Long doctorID, Long patientID) {
        this.description = description;
        this.timestamp = timestamp;
        this.doctorID = doctorID;
        this.patientID = patientID;
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

    public Long getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Long doctorID) {
        this.doctorID = doctorID;
    }

    public Long getPatientID() {
        return patientID;
    }

    public void setPatientID(Long patientID) {
        this.patientID = patientID;
    }
}
