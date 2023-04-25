package com.mindwise.backend.repository;

import com.mindwise.backend.model.DPMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface DPMapRepository extends JpaRepository<DPMap,Long> {
    DPMap getAllByPatientID(Long patientID);

    @Query(value = "SELECT patientID from DPMap dp where dp.doctorID = :docID" , nativeQuery = true)
    List<Long> getPatientsbyDoctorID(@Param("docID") Long docID);

//    List<Long> getDocidByPatientID(Long patientID);
}
