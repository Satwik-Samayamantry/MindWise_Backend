package com.mindwise.backend.repository;

import com.mindwise.backend.model.PatientExercises;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;
public interface PatientExercisesRepository extends JpaRepository<PatientExercises,Long> {
    @Query(value = "SELECT exerciseid from patient_exercises pe where pe.patientid = :patientid" , nativeQuery = true)
    List<Long> getExerciseIDbypatientID(@Param("patientid") Long patientid);

    List<PatientExercises> getAllByPatientID(Long patientID);

    Long countByPatientID(Long patientID);
    Long countByPatientIDAndCompletionstatus(Long patientID, Integer completionstatus);
    void deleteByPatientIDAndExerciseID(@Param("patientid") Long patientid, @Param("exerciseid") Long exerciseid);

}
