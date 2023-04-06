package com.mindwise.backend.repository;

import com.mindwise.backend.model.LoginDetails;
import com.mindwise.backend.model.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    @Query(value = "SELECT * from patient p where p.username = :username" , nativeQuery = true)
    Patient getIDByUsername(@Param("username") String username);

}
