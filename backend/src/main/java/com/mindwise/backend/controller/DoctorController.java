package com.mindwise.backend.controller;

import com.mindwise.backend.model.Doctor;
import com.mindwise.backend.model.Patient;
import com.mindwise.backend.repository.DoctorRepository;
import com.mindwise.backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping("/doctor")
    Doctor newDoctor(@RequestBody Doctor newDoctor)
    {
        return doctorRepository.save(newDoctor);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/doctors")
    List<Doctor> getAllDoctors()
    {
        // return "Hello World";
        return doctorRepository.findAll();
    }

    @GetMapping("/getdoctorid")
    Doctor getCurrentDoctorDetails(@RequestParam("username") String username)
    {
        Doctor d1 = new Doctor(null, null, null, null, null, null, null);
        try
        {
            Doctor d = doctorRepository.getDoctorIDbyUsername(username);
            return d;
        }


        catch(Exception e)
        {
            e.printStackTrace();
        }
        return d1;
    }

    @GetMapping("/getdocnamebydocid")
    String getnamebyid(@RequestParam("docid") Long doctorId)
    {
        Doctor temp = doctorRepository.getAllByDoctorID((doctorId));
        return temp.getName();
    }

}
