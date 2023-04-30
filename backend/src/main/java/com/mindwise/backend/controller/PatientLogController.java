package com.mindwise.backend.controller;


import com.mindwise.backend.model.PatientLog;
import com.mindwise.backend.repository.PatientLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PatientLogController {

    @Autowired
    private PatientLogRepository patientLogRepository;

    @PostMapping("/logfeelings")
    PatientLog newPatientlog(@RequestBody PatientLog newPatientlog)
    {
        return patientLogRepository.save(newPatientlog);
    }

    @GetMapping("/getlogsbydocid")
    List<PatientLog> getpatientlogsbydocid(@RequestParam("doctorID") Long doctorID)
    {
        return patientLogRepository.getAllByDoctorID(doctorID);
    }
}
