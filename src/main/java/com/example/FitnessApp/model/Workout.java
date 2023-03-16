package com.example.FitnessApp.model;

import java.time.LocalDate;

public class Workout {

    private int workoutId;
    private String workoutName;
    private String workoutDescription;
    private int weight;
    private int reps;
    private int bodyGroupId;
    private LocalDate date;
    private int sets;

    public Workout() {
    }

    public Workout(int workoutId, String workoutName, String workoutDescription, int weight, int reps, int bodyGroupId, LocalDate date, int sets) {
        this.workoutId = workoutId;
        this.workoutName = workoutName;
        this.workoutDescription = workoutDescription;
        this.weight = weight;
        this.reps = reps;
        this.bodyGroupId = bodyGroupId;
        this.date = date;
        this.sets = sets;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(int workoutId) {
        this.workoutId = workoutId;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public String getWorkoutDescription() {
        return workoutDescription;
    }

    public void setWorkoutDescription(String workoutDescription) {
        this.workoutDescription = workoutDescription;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }


    public int weightDifference(int previousWeight) {
        int weightChange = weight - previousWeight;
        return weightChange;
    }

    public String toString() {
        return "workouts {" +
                "workout_id=" + workoutId +
                ", workout_name=" + workoutName +
                ", description=" + workoutDescription +
                ", weight=" + weight +
                ", reps=" + reps +
                ", body_group_id=" + bodyGroupId +
                ", date=" + date +
                ", sets=" + sets +
                '}';
    }

    public int getBodyGroupId() {
        return bodyGroupId;
    }

    public void setBodyGroupId(int bodyGroupId) {
        this.bodyGroupId = bodyGroupId;
    }
}


