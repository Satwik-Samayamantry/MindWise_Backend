package com.mindwise.backend.repository;

import com.mindwise.backend.model.Notifications;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;

import java.util.*;

public interface NotificationsRepository extends JpaRepository<Notifications,Long> {
    List<Notifications> getAllByDoctorID(@Param("docID") Long docID);
    List<Notifications> getAllByPatientID(@Param("patientID") Long patientID);
    List<Notifications> getAllByPatientIDAndDoctorID(Long patientID, Long doctorID);

}
