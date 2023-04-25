package com.mindwise.backend.repository;

import com.mindwise.backend.model.LoginDetails;
import com.mindwise.backend.model.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
//    @Query(value = "SELECT * from patient p where p.username = :username" , nativeQuery = true)
    Patient getIdByUsername(String username);

    Patient getAllByUsername(String username);

    @Query(value = "SELECT * from patient p where p.patientid in :patientids" , nativeQuery = true)
    List<Patient> getPatientFromPatIDs(@Param("patientids") List<Long> patientids);


}
