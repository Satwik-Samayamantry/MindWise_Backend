package com.mindwise.backend.controller;

import com.mindwise.backend.model.Exercises;
import com.mindwise.backend.model.PatientExercises;
import com.mindwise.backend.repository.PatientExercisesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class PatientExercisesController {
    @Autowired
    private PatientExercisesRepository patientexercisesRepository;

    @PostMapping("/patientexercise")
    PatientExercises newPatient(@RequestBody PatientExercises newPatientExercises)
    {
        return patientexercisesRepository.save(newPatientExercises);
    }

    @GetMapping("/patientexercises")
    List<PatientExercises> getAllPatientExercises()
    {
        // return "Hello World";
        return patientexercisesRepository.findAll();
    }

    @GetMapping("/getexercisesfrompid")
    List<PatientExercises> getexercisesfrompid(@RequestParam("patientid") Long patientID)
    {
        return patientexercisesRepository.getAllByPatientID(patientID);
    }

    @GetMapping("/getexerciseidfrompatient")
    List<Long> getAllexercisesforpatient(@RequestParam("patientid") String patientID)
    {
        List<Long> exercid = null;
        Long patientid = Long.parseLong(patientID);
        try
        {
            List<Long> Exercid = patientexercisesRepository.getExerciseIDbypatientID(patientid);
            return Exercid;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return exercid;
    }

    @GetMapping("getcountbypid")
    Long getCountOfAllTsksforP(@RequestParam("patientID") Long patientID)
    {
        return patientexercisesRepository.countByPatientID(patientID);
    }

    @GetMapping("getcountpidandcs")
    Long getCountofCS(@RequestParam("patientID") String patientID, @RequestParam("completionstatus") String completionstatus)
    {
        return patientexercisesRepository.countByPatientIDAndCompletionstatus(Long.parseLong(patientID), Integer.parseInt(completionstatus));
    }

    @Transactional
    @DeleteMapping("/deletemappingexepat")
    void deletemappingByPatientIDAndExerciseID(@RequestParam("patientid") Long patientid, @RequestParam("exerciseid") Long exerciseid)
    {

        patientexercisesRepository.deleteByPatientIDAndExerciseID(patientid, exerciseid);
    }
}
