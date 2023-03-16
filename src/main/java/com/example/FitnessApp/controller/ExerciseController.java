package com.example.FitnessApp.controller;

import com.example.FitnessApp.dao.ExerciseDao;
import com.example.FitnessApp.model.Exercise;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/exercises")
public class ExerciseController {
    private ExerciseDao dao;

    public ExerciseController(ExerciseDao dao) {
        this.dao = dao;
    }

    @RequestMapping(path="/muscle/{muscleGroup}", method= RequestMethod.GET)
    public List<Exercise> getExercisesByMuscle(@PathVariable String muscleGroup){
        return dao.exercisesByMuscle(muscleGroup);
    }

    @RequestMapping(path="/type/{type}", method= RequestMethod.GET)
    public List<Exercise> getExercisesByType(@PathVariable String type){
        return dao.exercisesByType(type);
    }

    @RequestMapping(path="/name/{name}", method= RequestMethod.GET)
    public List<Exercise> getExercisesByName(@PathVariable String name){
        return dao.exercisesByName(name);
    }

    @RequestMapping(path="/difficulty/{difficulty}", method= RequestMethod.GET)
    public List<Exercise> getExercisesByDifficulty(@PathVariable String difficulty){
        return dao.exercisesByDifficulty(difficulty);
    }

    @RequestMapping(path="/search", method= RequestMethod.GET)
    public List<Exercise> getExercisesBySearch(@RequestBody Exercise exercise){
        return dao.exercisesBySearch(exercise);
    }
}
