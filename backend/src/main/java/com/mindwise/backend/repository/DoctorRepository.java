package com.mindwise.backend.repository;

import com.mindwise.backend.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    @Query(value = "SELECT * from doctor d where d.username = :username" , nativeQuery = true)
    Doctor getDoctorIDbyUsername(@Param("username") String username);


    Doctor getAllByDoctorID(Long doctorID);
}

