package com.mindwise.backend.repository;

import com.mindwise.backend.model.Exercises;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExercisesRepository extends JpaRepository<Exercises,Long> {
    Exercises getAllByExerciseID(Long exerciseID);

    List<Exercises> getAllByDefaultflag(Integer defaultflag);
}