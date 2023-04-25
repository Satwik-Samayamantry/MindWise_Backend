package com.mindwise.backend.model;

import jakarta.persistence.*;


@Entity
public class PatientExercises {
    public Long getPatientExerciseID() {
        return patientexerciseID;
    }

    public void setPatientExerciseID(Long patientexerciseID) {
        this.patientexerciseID = patientexerciseID;
    }

    @Id
    @GeneratedValue
    private Long patientexerciseID;

    private Long exerciseID;

    private Long patientID;

    private Integer completionstatus;


    public PatientExercises() {
    }

    public PatientExercises(Long patientID, Long exerciseID, Integer completionstatus) {
        this.exerciseID = exerciseID;
        this.patientID = patientID;
        this.completionstatus = completionstatus;
    }

    public Long getExerciseID() {
        return exerciseID;
    }

    public void setExerciseID(Long exerciseID) {
        this.exerciseID = exerciseID;
    }

    public Long getPatientID() {
        return patientID;
    }

    public void setPatientID(Long patientID) {
        this.patientID = patientID;
    }

    public Integer getCompletionstatus() {
        return completionstatus;
    }

    public void setCompletionstatus(Integer completionstatus) {
        this.completionstatus = completionstatus;
    }
}

