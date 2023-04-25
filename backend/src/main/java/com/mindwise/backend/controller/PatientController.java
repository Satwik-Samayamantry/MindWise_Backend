package com.mindwise.backend.controller;

import com.mindwise.backend.model.Patient;
import com.mindwise.backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/getpatientbyusername")
    Patient patientbyusername(@RequestParam("username") String username)
    {
        Patient result = new Patient(null,null,null,null);
        try
        {
            Patient temp = patientRepository.getAllByUsername(username);
            return temp;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("/getpatientfordoc")
    List<Patient> getAllPatientsForDoc(@RequestParam("patientids") List<Long> patientids)
//List<Patient> getAllPatientsForDoc(@RequestBody Long[] patientids)
    {
        List<Patient> details = null;


        try {
            List<Patient> Details = patientRepository.getPatientFromPatIDs(patientids);
            return Details;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return details;
    }

    @PostMapping("/setstatus")
    void updatestatus(@RequestBody Map<String,String> data)
    {
        String username = data.get("username");
        String status = data.get("status");
//        System.out.println(username);
//        System.out.println(status);
        Patient temp = patientRepository.getAllByUsername(username);
        temp.setStatus(Integer.parseInt(status));
        patientRepository.save(temp);
    }

}
