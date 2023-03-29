package com.mindwise.backend.repository;

import com.mindwise.backend.model.Doctor;
import com.mindwise.backend.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
