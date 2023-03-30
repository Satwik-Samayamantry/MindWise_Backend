//package com.mindwise.backend.repository;
//
//public interface ExercisesRepository {
//}

package com.mindwise.backend.repository;

import com.mindwise.backend.model.Doctor;
import com.mindwise.backend.model.Patient;
import com.mindwise.backend.model.Exercises;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExercisesRepository extends JpaRepository<Exercises,Long> {
}