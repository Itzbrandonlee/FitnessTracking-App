package com.example.FitnessApp.dao;

import com.example.FitnessApp.model.Exercise;

import java.util.List;

public interface ExerciseDao {
    List<Exercise> exercisesByMuscle(String muscle);
    List<Exercise> exercisesByType(String type);
    List<Exercise> exercisesByName(String name);
    List<Exercise> exercisesByDifficulty(String difficulty);
    List<Exercise> exercisesBySearch(Exercise exercise);
}
