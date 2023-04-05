package com.mindwise.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class DPMap {
    @Id
    @GeneratedValue
    private Long DPID;

    private Long doctorID;
    private Long patientID;
    private String summary;

    public DPMap(Long doctorID, Long patientID, String summary) {
        this.doctorID = doctorID;
        this.patientID = patientID;
        this.summary = summary;
    }

    public DPMap(){

    }

    public Long getDPID() {
        return DPID;
    }

    public void setDPID(Long DPID) {
        this.DPID = DPID;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
