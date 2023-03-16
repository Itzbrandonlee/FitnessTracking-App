package com.example.FitnessApp.dao;

import com.example.FitnessApp.model.Bodygroup;
import com.example.FitnessApp.model.Workout;


import java.time.LocalDate;
import java.util.List;

public interface WorkoutDao {

    public List<Workout> getAllWorkouts();
    public List<Workout> getWorkoutsByUserId(int userId);
    public List<Workout> getWorkoutsByBodygroup(String bodyGroupName);
    public List<Workout> getWorkoutsByDate(LocalDate date);
    public Workout getWorkoutById(int workoutId);
    public void addNewWorkout(Workout newWorkout, int userId);
    public void updateWorkout(Workout updatedWorkout, int workoutId);
    public void deleteWorkout(int workoutId);
}
