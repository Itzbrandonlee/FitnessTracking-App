package com.example.FitnessApp.controller;

import com.example.FitnessApp.dao.WorkoutDao;
import com.example.FitnessApp.model.Workout;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/workouts")
@CrossOrigin
public class WorkoutController {

    public WorkoutDao dao;

    public WorkoutController(WorkoutDao dao) {
        this.dao = dao;
    }

    @RequestMapping(path="/all", method = RequestMethod.GET)
    public List<Workout> getAllWorkouts(){
        return dao.getAllWorkouts();
    }

    @RequestMapping(path="/user/{id}", method = RequestMethod.GET)
    public List<Workout> getWorkoutByUserId(@PathVariable int id, Principal principal){
        return dao.getWorkoutsByUserId(id);
    }

    @RequestMapping(path="/", params = "bodyGroup", method = RequestMethod.GET)
    public List<Workout> getWorkoutsByBodyGroup(@RequestParam("bodyGroup") String bodyGroup){
        return dao.getWorkoutsByBodygroup(bodyGroup);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public Workout getWorkoutById(@PathVariable int id){
        return dao.getWorkoutById(id);
    }

    @RequestMapping(path="/bydate/", params = "date", method = RequestMethod.GET)
    public List<Workout>getWorkoutsByDate(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        return dao.getWorkoutsByDate(date);
    }

    @RequestMapping(path="/new/{id}", method = RequestMethod.POST)
    public void addNewWorkout(@Valid @RequestBody Workout newWorkout, @PathVariable int id){
        dao.addNewWorkout(newWorkout, id);
    }

    @RequestMapping(path="/update/{id}", method = RequestMethod.PUT)
    public void updateWorkout(@Valid @RequestBody Workout updateWorkout, @PathVariable int id){
        dao.updateWorkout(updateWorkout, id);
    }

    @RequestMapping(path="/delete/{id}", method = RequestMethod.DELETE)
    public void deleteWorkout(@PathVariable int id){
        dao.deleteWorkout(id);
    }
}
