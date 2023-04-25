package com.mindwise.backend.controller;

import com.mindwise.backend.model.Exercises;
import com.mindwise.backend.repository.ExercisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
public class ExercisesController {
    @Autowired
    private ExercisesRepository exercisesRepository;


    @PostMapping("/exercise")
    Exercises newExercise(@RequestBody Exercises newExercise)
    {
        return exercisesRepository.save(newExercise);
    }

    @GetMapping("/exercises")
    List<Exercises> getAllExercises()
    {
        // return "Hello World";
        return exercisesRepository.findAll();
    }

    @GetMapping("/exercisebyid")
    Exercises exercisebyeid(@RequestParam("exerciseid") Long exerciseid)
    {
        return exercisesRepository.getAllByExerciseID(exerciseid);
    }

}

