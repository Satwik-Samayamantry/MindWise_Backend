package com.mindwise.backend.repository;

import com.mindwise.backend.model.LoginDetails;
import com.mindwise.backend.model.Patient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {

}
