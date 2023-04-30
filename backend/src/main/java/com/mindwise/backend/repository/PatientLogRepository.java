package com.mindwise.backend.repository;

import com.mindwise.backend.model.PatientLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientLogRepository extends JpaRepository<PatientLog,Long> {

List<PatientLog> getAllByDoctorID(Long Doctorid);
}
