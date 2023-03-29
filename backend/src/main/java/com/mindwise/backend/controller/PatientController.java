package com.mindwise.backend.controller;

import com.mindwise.backend.model.Patient;
import com.mindwise.backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/patient")
    Patient newPatient(@RequestBody Patient newPatient)
    {
        return patientRepository.save(newPatient);
    }

    @GetMapping("/patients")
    List<Patient> getAllPatients()
    {
        // return "Hello World";
        return patientRepository.findAll();
    }

}
